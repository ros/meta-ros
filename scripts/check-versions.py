#!/usr/bin/env python3

# Copyright (c) 2017, Blueye Robotics AS
#
# check-version.py is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# check-version.py is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# See <https://www.gnu.org/licenses/gpl-3.0.html> for full license text.

import os
import urllib.request
import sys
import re
import hashlib
from distutils.version import LooseVersion
import yaml

__author__ = "Johannes Schrimpf"
__copyright__ = "Copyright 2017, Blueye Robotics AS"
__credits__ = ["Johannes Schrimpf"]
__license__ = "GPLv3"

BASE_DIR = "../recipes-ros"
DEBUG = False
EXCLUDE = ["packagegroups"]


class MoveRepoExcetion(Exception):
    pass


class DistroUrlException(Exception):
    pass


class Distribution():
    data = None

    @staticmethod
    def get_version(package):
        if Distribution.data is None:
            Distribution.data = yaml.load(urllib.request.urlopen(DIST_FILE).read())
        package = package.replace("-", "_")
        return Distribution.data["repositories"][package]["release"]["version"]

    @staticmethod
    def get_url(package):
        if Distribution.data is None:
            Distribution.data = yaml.load(urllib.request.urlopen(DIST_FILE).read())
        package = package.replace("-", "_")
        try:
            return Distribution.data["repositories"][package]["source"]["url"].split(".git")[0]
        except KeyError:
            raise DistroUrlException()


def print_debug(text):
    if DEBUG:
        print(text)


def print_err(text):
    pre = '\033[91m'
    post = '\033[0m'
    print(pre + text + post)


def print_ok(text):
    pre = '\033[92m'
    post = '\033[0m'
    print(pre + text + post)


def check_version(package, print_info="none", details=False):
    printlist = []
    package_dir = os.path.join(BASE_DIR, package)
    versions = set()
    version = None
    try:
        dist_ver = Distribution.get_version(package)
        dist_ver = dist_ver.split("-")[0]
    except KeyError:
        dist_ver = ""
    for filename in (os.path.join(package_dir, fn) for fn in os.listdir(package_dir)
                     if fn.endswith(".bb")):
        version = filename.split("_")[1].split(".bb")[0]
        versions.update([version])

        if details:
            printlist.append(" - " + os.path.basename(filename))
    if len(versions) > 1:
        print("Package: %s" % package)
        print(versions)
        raise Exception("Multiple versions per package not supported at this time")

    if version is None:
        version = "n.a."
    match = dist_ver == version

    if print_info == "all" or print_info == "mismatch" and not match:
        if dist_ver == "":
            pre = post = ""
            mid = "   "
        elif version == "git":
            mid = "   "
            pre = post = ""
        else:
            pre = '\033[92m' if match else '\033[91m'
            post = '\033[0m'
            if match:
                mid = " = "
            else:
                assert LooseVersion(version) != LooseVersion(dist_ver)
                if LooseVersion(version) > LooseVersion(dist_ver):
                    mid = " > "
                elif LooseVersion(dist_ver) > LooseVersion(version):
                    mid = " < "
        print(package.ljust(35) + pre + version.ljust(10) + mid + dist_ver.ljust(10) + post)
        for line in printlist:
            print(line)
    return match, version, dist_ver


def get_checksums_from_url(url):
    data = urllib.request.urlopen(url).read()
    md5sum = hashlib.md5()
    md5sum.update(data)
    md5sum_hex = md5sum.hexdigest()
    sha256sum = hashlib.sha256()
    sha256sum.update(data)
    sha256sum_hex = sha256sum.hexdigest()
    return md5sum_hex, sha256sum_hex


def update_checksums_in_file(package, filename, dist_version):
    with open(filename) as recipe_file:
        data = recipe_file.read()

    ros_pv = dist_version
    ros_spn = package.replace('-', '_')
    ros_sp = "%s-%s" % (ros_spn, ros_pv)

    url = re.search(r'SRC_URI\s*=\s*"(\S*)\s*["\\]', data).group(1)
    url = url.replace("${ROS_SPN}", ros_spn)
    url = url.replace("${ROS_SP}", ros_sp)
    url = url.replace("${PV}", ros_pv)

    if "protocol=git" in url:
        print_err("Using git protocol. Please update manually.")

    url = url.split(";")[0]

    repo = Distribution.get_url(package)

    if repo not in url:
        print(url)
        print(repo)
        raise MoveRepoExcetion()

    try:
        md5sum = re.search(r'SRC_URI\[md5sum\]\s*=\s*"(\S*)"', data).group(1)
    except AttributeError:
        print_err("Error reading md5sum in package %s. Please update manually." % package)
        return False
    try:
        sha256sum = re.search(r'SRC_URI\[sha256sum\]\s*=\s*"(\S*)"', data).group(1)
    except AttributeError:
        print_err("Error reading sha256sum in package %s. Please update manually." % package)
        return False

    if len(md5sum) != 32 and len(sha256sum) != 64:
        print_err("Failed reading checksums.")
        return False

    md5sum_new, sha256sum_new = get_checksums_from_url(url)
    print_debug("Updating checksums in file %s" % filename)
    print_debug("old md5: %s" % md5sum)
    print_debug("new md5: %s" % md5sum_new)
    print_debug("old sha256: %s" % sha256sum)
    print_debug("new sha256: %s" % sha256sum_new)
    with open(filename) as recipe_file:
        recipe_data = recipe_file.read()
    recipe_data = recipe_data.replace(md5sum, md5sum_new)
    recipe_data = recipe_data.replace(sha256sum, sha256sum_new)
    with open(filename, 'w') as recipe_file:
        recipe_file.write(recipe_data)
    return True


def update_all_packages():
    for package in (x for x in sorted(os.listdir(BASE_DIR)) if x not in EXCLUDE and
                    os.path.isdir(os.path.join(BASE_DIR, x))):
        if not check_version(package)[0]:
            update_package(package)


def update_package(package):
    print_debug("Updating %s" % package)
    print_header()
    match, version, dist_version = check_version(package, print_info="all", details=True)
    if match:
        print("Packet is already in newest version")
        return
    if dist_version == "":
        print("Packet not found in dist file")
        return

    if version == "git":
        print("Layer uses git version. Please update manually")
        return
    elif LooseVersion(version) > LooseVersion(dist_version) and "--downgrade" not in sys.argv:
        print("Layer version is newer than dist version, " +
              "use --downgrade as last argument to downgrade")
        return

    try:
        path = os.path.join(BASE_DIR, package)

        update_include = False
        rename_requests = []
        for recipe in (os.path.join(path, fn) for fn in os.listdir(path) if fn.endswith(".bb")):
            with open(recipe) as recipe_file:
                data = recipe_file.read()

            old_fn = os.path.join(recipe)
            new_fn = os.path.join(recipe.replace(version, dist_version))
            rename_requests.append([old_fn, new_fn])

            if "SRC_URI[md5sum]" not in data and "SRC_URI[sha256sum]" not in data:
                update_include = True
            else:
                update_checksums_in_file(package, old_fn, dist_version)

        if update_include:
            inc_fn = os.path.join(BASE_DIR, package, package + ".inc")
            update_checksums_in_file(package, inc_fn, dist_version)
    except MoveRepoExcetion:
        print_err("Repo moved %s" % package)
    except DistroUrlException:
        print_err("Cannot retrieve source url for %s" % package)
    else:
        print_debug("Renaming files for %s" % package)
        for [old_fn, new_fn] in rename_requests:
            print_debug("old: %s" % old_fn)
            print_debug("new: %s" % new_fn)
            os.rename(old_fn, new_fn)
        print_ok("Updated")


def print_header():
    print("\033[1m\033[4m" + "package".ljust(35) + "layer".ljust(13) +
          "distro".ljust(10) + '\033[0m')


def print_list(details=False):
    print_header()
    for package in (x for x in sorted(os.listdir(BASE_DIR)) if x not in EXCLUDE and
                    os.path.isdir(os.path.join(BASE_DIR, x))):
        check_version(package, details=details, print_info="all")


def print_mismatch(details=False):
    print_header()
    for package in (x for x in sorted(os.listdir(BASE_DIR)) if x not in EXCLUDE and
                    os.path.isdir(os.path.join(BASE_DIR, x))):
        check_version(package, details=details, print_info="mismatch")


def print_help():
    filename = sys.argv[0]
    print("Usage:")
    print("List all versions:                  %s list (--details)" % filename)
    print("List all versions that don't match: %s mismatch (--details)" % filename)
    print("Update recipe to dist version:      %s update <package> (--downgrade)" % filename)
    print("Update all recipes to dist version: %s update-all (--downgrade)" % filename)


if __name__ == "__main__":
    with open("../conf/layer.conf") as layerfile:
        DISTRO = re.search(r'ROSDISTRO\s:=\s*"(\S*)\s*["\\]', layerfile.read()).group(1)
    DIST_FILE = "https://raw.githubusercontent.com/ros/rosdistro/master/" +\
                DISTRO + "/distribution.yaml"
    if len(sys.argv) == 1:
        print_help()
    else:
        if sys.argv[1] == "list":
            print_list(details="--details" in sys.argv)
        elif sys.argv[1] == "mismatch":
            print_mismatch(details="--details" in sys.argv)
        elif sys.argv[1] == "update" and len(sys.argv) >= 3:
            update_package(sys.argv[2])
        elif sys.argv[1] == "update-all":
            update_all_packages()
        else:
            print_help()
