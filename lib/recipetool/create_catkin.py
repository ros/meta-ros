#!/usr/bin/python3
"""Recipe creation tool - catkin support plugin."""

# Copyright (C) 2017 Intel Corporation
#
# This program is free software; you can redistribute it and/or modify
# it under the terms of the GNU General Public License version 2 as
# published by the Free Software Foundation.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License along
# with this program; if not, write to the Free Software Foundation, Inc.,
# 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.

import re
import logging

from html.parser import HTMLParser
from lxml import etree

import hashlib

from recipetool.create import RecipeHandler
from recipetool.create_buildsys import CmakeExtensionHandler

LOGGER = logging.getLogger('recipetool')


class RosHTMLParser(HTMLParser):
    """ROS HTML Parser class.

    Primarily for removing any XHTML from the <description> tag.
    See: http://www.ros.org/reps/rep-0127.html#description (Format 1)
    See: http://www.ros.org/reps/rep-0140.html#description (Format 2)
    """

    basic_text = ""

    def handle_data(self, data):
        """Override HTMLParser handle_data method."""
        if len(self.basic_text) > 0:
            self.basic_text = self.basic_text + " "
        self.basic_text = self.basic_text + data.strip()


class RosXmlParser:
    """ROS package.xml Parser class.

    Uses the etree class from lxml to parse the ROS package.xml file.
    This file is main source for information for constructing the BitBake
    recipe for the ROS package.

    See: http://www.ros.org/reps/rep-0127.html (Format 1)
    See: http://www.ros.org/reps/rep-0140.html (Format 2)
    """

    package_format = 0

    def __init__(self, xml_path):
        """Initialize the class by finding the package format version."""
        # Default to ROS package format 1
        # http://wiki.ros.org/catkin/package.xml#Format_1_.28Legacy.29
        self.package_format = 1

        self.xml_path = xml_path
        self.tree = etree.parse(self.xml_path)
        # Check the ROS package format
        # http://wiki.ros.org/catkin/package.xml#Format_1_.28Legacy.29
        # or
        # http://wiki.ros.org/catkin/package.xml#Format_2_.28Recommended.29
        package_format_list = self.tree.xpath("/package[@format]")
        for pkg_format in package_format_list:
            self.package_format = int(pkg_format.get('format',
                                      self.package_format))
        if self.package_format > 2:
            self.package_format = 2
            LOGGER.warning("FORCING ROS Package Format to version " +
                           str(self.package_format))
        elif self.package_format < 1:
            self.package_format = 1
            LOGGER.warning("FORCING ROS Package Format to version " +
                           str(self.package_format))

        LOGGER.debug("ROS Package Format version " + str(self.package_format))

    def get_format(self):
        """Return the package.xml format version."""
        return str(self.package_format)

    def clean_string(self, raw_string):
        """Remove white space and sanitize the string.

        Replace double quotes with single quotes as bitbake
        recipes variables will be set with double quotes.
        """
        return re.sub(r'\s+', ' ', raw_string.strip().replace('"', "'"))

    def get_single(self, xpath, required=True):
        """Return a single string value for the given xpath."""
        xpath_list = self.tree.xpath(xpath)
        if len(xpath_list) < 1:
            if required:
                LOGGER.error("ROS package.xml missing element " + str(xpath))
                return None
        elif len(xpath_list) > 1:
            LOGGER.warning("ROS package.xml has more than 1 match for " +
                           str(xpath))

        return self.clean_string(xpath_list[0].text)

    def get_multiple_with_type(self, xpath, required=False):
        """Return dict of type attributes and the matching urls from xpath."""
        items = {}
        xpath_list = self.tree.xpath(xpath)
        if len(xpath_list) < 1:
            if required:
                LOGGER.error("ROS package.xml missing element " + str(xpath))
        for item in xpath_list:
            url_string = self.clean_string(item.text)
            url_type = self.clean_string(item.get('type', '')).lower()
            items[url_type] = url_string

        return items

    def get_multiple_with_email(self, xpath, required=True):
        """Return list of string values and email attrib for given xpath."""
        items = []
        xpath_list = self.tree.xpath(xpath)
        if len(xpath_list) < 1:
            if required:
                LOGGER.error("ROS package.xml missing element " + str(xpath))
        for item in xpath_list:
            fullstring = self.clean_string(item.text)
            email = self.clean_string(item.get('email', ''))
            if len(email) > 0:
                fullstring = fullstring + " <" + email + ">"
            items.append(fullstring)

        return items

    def get_multiple_with_version(self, xpath, required=False):
        """Return list of dependencies and version attribs for given xpath."""
        def catkin_to_bitbake(version_type):
            """Map the Catkin version modifier to BitBake."""
            mapper = {
                    "version_lt": "<",
                    "version_lte": "<=",
                    "version_eq": "=",
                    "version_gte": ">=",
                    "version_gt": ">",
                    }
            return mapper.get(version_type, "UNDEFINED")

        items = []
        xpath_list = self.tree.xpath(xpath)
        if len(xpath_list) < 1:
            if required:
                LOGGER.error("ROS package.xml missing element " + str(xpath))
        for item in xpath_list:
            fullstring = self.clean_string(item.text)
            if len(item.attrib) > 1:
                LOGGER.error("ROS package.xml element " + str(xpath) +
                             " has too many attributes!")
            for version_type in item.attrib:
                c_version_type = catkin_to_bitbake(version_type)
                c_value = self.clean_string(item.attrib[version_type])
                if len(c_value) > 1:
                    c_version_type = c_version_type + " " + c_value
                if len(c_version_type) > 1:
                    fullstring = fullstring + " (" + c_version_type + ")"
            items.append(fullstring)

        return items

    def get_multiple_with_linenumber(self, xpath, required=False):
        """Return dict of string and their line numbers for given xpath."""
        items = {}
        xpath_list = self.tree.xpath(xpath)
        if len(xpath_list) < 1:
            if required:
                LOGGER.error("ROS package.xml missing element " + str(xpath))
        for item in xpath_list:
            c_string = self.clean_string(item.text)
            items[c_string] = item.sourceline

        return items

    def get_name(self):
        """Return the Name of the ROS package."""
        return self.get_single("/package/name")

    def get_version(self):
        """Return the Version of the ROS package."""
        return self.get_single("/package/version")

    def get_description(self):
        """Return the Description of the ROS package.

        Remove the XHTML information, if present, and only return
        a simple text string description for the package.
        """
        parser = RosHTMLParser()
        parser.feed(self.get_single("/package/description"))
        return self.clean_string(parser.basic_text)

    def get_authors(self):
        """Return list of Authors of the ROS package."""
        return self.get_multiple_with_email("/package/author", required=False)

    def get_maintainers(self):
        """Return list of Maintainers of the ROS package."""
        return self.get_multiple_with_email("/package/maintainer")

    def get_urls(self):
        """Return list of Website URLs for the ROS package."""
        return self.get_multiple_with_type("/package/url", required=False)

    def get_licenses(self):
        """Return list of Licenses of the ROS package."""
        return self.get_multiple_with_linenumber("/package/license")

    def get_build_dependencies(self):
        """Return list of package Build Dependencies of the ROS package."""
        dependencies = []

        # build_depend is both format 1 & 2
        for dependency in self.get_multiple_with_version(
                "/package/build_depend"):
            dependencies.append(dependency.replace("_", "-"))
        if self.package_format > 1:
            for dependency in self.get_multiple_with_version(
                    "/package/depend"):
                dependencies.append(dependency.replace("_", "-"))

        # remove any duplicates
        dependencies = list(set(dependencies))

        return dependencies

    def get_runtime_dependencies(self):
        """Return list of package Run Dependencies of the ROS package."""
        dependencies = []

        # run_depend is format 1 only
        if self.package_format == 1:
            for dependency in self.get_multiple_with_version(
                    "/package/run_depend"):
                dependencies.append(dependency.replace("_", "-"))
        if self.package_format == 2:
            for dependency in self.get_multiple_with_version(
                    "/package/exec_depend"):
                dependencies.append(dependency.replace("_", "-"))
            for dependency in self.get_multiple_with_version(
                    "/package/depend"):
                dependencies.append(dependency.replace("_", "-"))

        # remove any duplicates
        dependencies = list(set(dependencies))

        return dependencies


class CatkinRecipeHandler(RecipeHandler):
    """Catkin handler extension for recipetool."""

    def process_license(self,
                        srctree, classes, lines_before,
                        lines_after, handled, extravalues,
                        licenses, license_file):
        """Generate the Catkin license data.

        licenses: a dictionary of license:line_number
        license_file: the name of the license file
        """
        all_lines = []
        license_keys = list(licenses.keys())

        def get_license_checksum(license):
            """Output the license details."""
            line_number = licenses[license]

            m = hashlib.md5()
            try:
                lic_line = all_lines[line_number - 1]
                m.update(lic_line.encode('utf-8'))
                md5val = m.hexdigest()
            except UnicodeEncodeError:
                md5val = None

            LOGGER.debug("License: '" + license + "' on line " +
                         str(line_number) + " with md5 " + md5val)

            checksum = "file://" + os.path.basename(license_file) + \
                ";" + "beginline=" + str(line_number) + ";endline=" + \
                str(line_number) + ";md5=" + md5val
            return checksum

        try:
            lic_file = open(license_file)
            all_lines = lic_file.readlines()
            lic_file.close()
        except:
            LOGGER.error("License file '" + license_file + "'not readable!")
            return False

        checksum_files = []
        if len(license_keys) > 0:
            checksum_files.append(get_license_checksum(license_keys[0]))
            del license_keys[0]

            for license in license_keys:
                checksum_files.append(get_license_checksum(license))

            # Commas are not valid in BitBake License name
            clean_keys = [re.sub(r',', '', lic) for lic in licenses.keys()]

            extravalues['LICENSE'] = " & ".join(clean_keys)
            extravalues['LIC_FILES_CHKSUM'] = " ".join(checksum_files)

            handled.append('license')

    def process(self, srctree, classes, lines_before, lines_after, handled,
                extravalues):
        """Process the Catkin recipe.

        Read the key tags from the package.xml ROS file and generate
        the corresponding recipe variables for the recipe file.
        """
        package_list = RecipeHandler.checkfiles(srctree, ['package.xml'],
                                                recursive=False)
        if len(package_list) > 0:
            handled.append('buildsystem')

            for package_file in package_list:
                LOGGER.info("Found package_file: " + package_file)
                xml = RosXmlParser(package_file)

                classes.append('catkin')

                extravalues['PN'] = xml.get_name()  # Ignored if set
                extravalues['PV'] = xml.get_version()

                licenses = xml.get_licenses()
                if len(licenses) < 1:
                    LOGGER.error("package.xml missing required LICENSE field!")
                else:
                    self.process_license(srctree, classes, lines_before,
                                         lines_after, handled, extravalues,
                                         licenses, package_file)

                lines_after.append('# This is a Catkin (ROS) based recipe')
                lines_after.append('# ROS package.xml format version ' +
                                   xml.get_format())
                lines_after.append('')

                lines_after.append("SUMMARY = \"" +
                                   "ROS package " + xml.get_name() + "\"")
                lines_after.append("DESCRIPTION = \"" +
                                   xml.get_description() + "\"")

                # Map the Catkin URLs to BitBake
                urls = xml.get_urls()
                if 'website' in urls:
                    lines_after.append("HOMEPAGE = \"" +
                                       urls['website'] + "\"")
                else:
                    if '' in urls:
                        lines_after.append("HOMEPAGE = \"" +
                                           urls[''] + "\"")
                if 'bugtracker' in urls:
                    lines_after.append("# ROS_BUGTRACKER = \"" +
                                       urls['bugtracker'] + "\"")

                if 'repository' in urls:
                    lines_after.append("# SRC_URI = \"" +
                                       urls['repository'] + "\"")

                authors = xml.get_authors()
                if len(authors) > 0:
                    lines_after.append("# ROS_AUTHOR = \"" +
                                       authors[0] + "\"")
                    del authors[0]
                    for author in authors:
                        lines_after.append("# ROS_AUTHOR += \"" +
                                           author + "\"")

                maintainers = xml.get_maintainers()
                if len(maintainers) > 0:
                    lines_after.append("# ROS_MAINTAINER = \"" +
                                       maintainers[0] + "\"")
                    del maintainers[0]
                    for maintainer in maintainers:
                        lines_after.append("# ROS_MAINTAINER += \"" +
                                           maintainer + "\"")

                lines_after.append("SECTION = \"devel\"")

                dependencies = xml.get_build_dependencies()
                if len(dependencies) > 0:
                    lines_after.append("DEPENDS = \"" +
                                       dependencies[0] + "\"")
                    del dependencies[0]
                    for dependency in dependencies:
                        lines_after.append("DEPENDS += \"" +
                                           dependency + "\"")

                dependencies = xml.get_runtime_dependencies()
                if len(dependencies) > 0:
                    lines_after.append("RDEPENDS_${PN}-dev = \"" +
                                       dependencies[0] + "\"")
                    del dependencies[0]
                    for dependency in dependencies:
                        lines_after.append("RDEPENDS_${PN}-dev += \"" +
                                           dependency + "\"")
            return True

        return False


def register_recipe_handlers(handlers):
    """Register our recipe handler in front of default cmake handler.

    Catkin needs to be a higher priority than CMake (50).
    """
    handlers.append((CatkinRecipeHandler(), 90))
