#!/usr/bin/env python
# -*- coding: utf-8 -*-
#
# Copyright (c) 2016 David Bensoussan, Synapticon GmbH
# 
#
# Permission is hereby granted, free of charge, to any person obtaining a copy 
# of this software and associated documentation files (the "Software"), to
# deal  in the Software without restriction, including without limitation the 
# rights to use, copy, modify, merge, publish, distribute, sublicense, and/or 
# sell copies of the Software, and to permit persons to whom the Software is 
# furnished to do so, subject to the following conditions:
#
# The above copyright notice and this permission notice shall be included in 
# all copies or substantial portions of the Software.
#
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE 
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
# FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS 
# IN THE SOFTWARE.
#

import re
import hashlib
import urllib
import tarfile
import sys

from lxml import etree


def printUsage():
    print("Usage of commands:\n")
    print "-h/--help"
    print "-g <repository-name> <package-name> <package-version>"
    print "  Example: python create_ros_recipe.py -g OctoMap octomap-ros 0.4.0"


def printCommands():
    print("Summary of commands:\n")
    print "-h/--help                        - prints commands and example"
    print "-g/--generates                   - generates recipe of ros package"


def correct(string):
    return re.sub(r'\.(?! )', '. ', re.sub(r' +', ' ',
                                           re.sub(r'\n', '', string)))


class xmlParser:

    def __init__(self, xml_path):
        self.xml_path = xml_path
        self.tree = etree.parse(self.xml_path)

    def getName(self):
        return self.tree.xpath("/package/name")[0].text

    def getVersion(self):
        return self.tree.xpath("/package/version")[0].text

    # Sometimes the description has
    def getDescription(self):
        return correct(
            self.tree.xpath("/package/description")[0].text).lstrip(' ')

    def getAuthorName(self):
        return self.tree.xpath("/package/author")[0].text

    def getLicense(self):
        return self.tree.xpath("/package/license")[0].text

    def getDependencies(self):
        dependencies = []
        for dependency in self.tree.xpath("/package/build_depend"):
            dependencies.append(dependency.text.replace("_", "-"))
        return dependencies

    def getLicenseLineNumber(self):
        with open(self.xml_path) as file:
            for num, line in enumerate(file, 1):
                if 'license' in line:
                    return num
            return 'CLOSED'


class yoctoRecipe:

    def __init__(self, repository, name, version):
        self.name = name
        self.repository = repository
        self.version = version
        self.description = None
        self.url = None
        self.author = None
        self.license = None
        self.dependencies = None
        self.license_line = None
        self.license_md5 = None
        self.src_md5 = None
        self.src_sha256 = None

    def getLicenseMD5(self, license):
        if license == "BSD":
            return "d566ef916e9dedc494f5f793a6690ba5"
        elif license == "Mozilla Public License Version 1.1":
            return "e1b5a50d4dd59d8102e41a7a2254462d"
        elif license == "CC-BY-NC-SA-2.0":
            return "11e24f757f025b2cbebd5b14b4a7ca19"
        elif license == "LGPL-2.1":
            return "184dd1523b9a109aead3fbbe0b4262e0"
        elif license == "GPL":
            return "162b49cfbae9eadf37c9b89b2d2ac6be"
        elif license == "LGPL-2.1+":
            return "58d727014cda5ed405b7fb52666a1f97"
        elif license == "LGPLv2":
            return "46ee8693f40a89a31023e97ae17ecf19"
        elif license == "MIT":
            return "58e54c03ca7f821dd3967e2a2cd1596e"

    def getSrcMD5(self):
        return hashlib.md5(
            open("./" + self.getArchiveName(), 'rb').read()).hexdigest()

    def getSrcSha256(self):
        return hashlib.sha256(
            open("./" + self.getArchiveName(), 'rb').read()).hexdigest()

    def importXML(self):
        xml = xmlParser(self.getFolderName() + "/package.xml")
        self.description = xml.getDescription()
        self.author = xml.getAuthorName()
        self.license = xml.getLicense()
        self.dependencies = xml.getDependencies()
        self.license_line = xml.getLicenseLineNumber()
        self.license_md5 = self.getLicenseMD5(self.license)

    def getURL(self):
        return "https://github.com/" + \
               self.repository + "/" + \
               self.name.replace("-", "_") + \
               "/archive/" + str(self.version) + \
               ".tar.gz"

    def getFolderName(self):
        return self.name.replace("-", "_") + "-" + str(self.version)

    def getArchiveName(self):
        return self.name.replace("-", "_") + \
               "-" + str(self.version) + \
               ".tar.gz"

    # To debug
    def printXML(self):
        print self.name
        print self.version
        print self.description
        print self.author
        print self.license
        print self.dependencies

    def parseDependencies(self):
        dependencies_ = 'DEPENDS = \"'
        for f in self.dependencies:
            dependencies_ = dependencies_ + f + " "
        dependencies_ = dependencies_.rstrip() + "\""
        return dependencies_ + "\n"

    def downloadArchive(self):
        urllib.urlretrieve(self.getURL(), self.getArchiveName())

    def extractArchive(self):
        tar = tarfile.open(self.getArchiveName(), "r:gz")
        tar.extractall()
        tar.close()

    def createRecipe(self):
        filename = self.name.replace("_", "-") + "_" + self.version + ".bb"
        print "Recipe generated:\n" + filename
        file = open(self.name.replace("_", "-") +
                    "_" + self.version + ".bb", "w")

        file.write('DESCRIPTION = \"' + self.description.rstrip() + "\"\n")
        file.write('AUTHOR = \"' + self.author + '\"\n')
        file.write('SECTION = \"devel\"\n')
        file.write('LICENSE = \"' + self.license + "\"\n")
        file.write('LIC_FILES_CHKSUM = file://package.xml;beginline=' +
                   str(self.license_line) +
                   ";endline=" +
                   str(self.license_line) +
                   ";md5=" +
                   self.license_md5 +
                   "\"\n")
        file.write('\n')

        file.write(self.parseDependencies() + "\n")
        file.write('SRC_URI = ' +
                   "https://github.com/" + self.repository +
                   "/${ROS_SPN}/archive/${PV}.tar.gz;" +
                   "downloadfilename=${ROS_SP}.tar.gz\"\n  ")
        file.write('SRC_URI[md5sum] = \"' + self.getSrcMD5() + "\"\n")
        file.write('SRC_URI[sha256sum] = ' + self.getSrcSha256() + "\"\n")

        file.write('\n')
        file.write('S = \"${WORKDIR}/${ROS_SP}\"\n')
        file.write('\n')

        file.write('inherit catkin\n')

if __name__ == '__main__':
    if sys.argv[1] == "-h" or sys.argv[1] == "--help":
        printCommands()
        printUsage()
    if sys.argv[1] == "-g" or sys.argv[1] == "--generate":
        if len(sys.argv) == 5:
            recipe = yoctoRecipe(sys.argv[2], sys.argv[3], sys.argv[4])
            recipe.downloadArchive()
            recipe.extractArchive()
            recipe.importXML()
            recipe.createRecipe()
        else:
            print "Please provide 3 arguments"
            printUsage()
            printCommands()
    else:
        print "Please provide 3 arguments"
        printUsage()
        printCommands()
