#!/usr/bin/env python
#
# Copyright (c) 2013 Stefan Herbrechtsmeier, Bielefeld University
# 

import sys
import os
import xml.etree.ElementTree as ElementTree
import hashlib

filename = 'package.xml'

if len(sys.argv) > 1:
    filename = sys.argv[1]

if not os.path.isfile(filename):
    exit(-1)

tree  = ElementTree.parse(filename)
root = tree.getroot()

name = tree.findtext('name', '')
version = tree.findtext('version', '')
description = tree.findtext('description', '').strip()
license = tree.findtext('license', '')
homepage = tree.findtext('url', '')

f = file(filename)
license_line = ''
license_md5 = ''
i = 0
for line in f:
    i += 1
    if 'license' in line:
        license_line = str(i)
        md5 = hashlib.md5()
        md5.update(line)
        license_md5 = md5.hexdigest()
        break


buildtools = []
for e in root.findall('buildtool_depend'):
    buildtools.append(e.text)

depends = []
for e in root.findall('build_depend'):
    depends.append(e.text.replace('_', '-'))

print(name + '_' + version + ".bb")
print('')
print('DESCRIPTION = "' + description + '"')
if homepage:
  print('HOMEPAGE = "' + homepage + '"')
print('SECTION = "devel"')
print('LICENSE = "' + license + '"')
print('LIC_FILES_CHKSUM = "file://package.xml;beginline=' + license_line +
      ';endline=' + license_line + ';md5=' + license_md5 + '"')
if depends:
    print('')
    print('DEPENDS = "' + ' '.join(depends) + '"')
print('')
print('SRC_URI = ";downloadfilename=${P}.tar.gz"')
print('SRC_URI[md5sum] = ""')
print('SRC_URI[sha256sum] = ""')
print('')
print('S = "${WORKDIR}/-${PV}"')
print('')
if buildtools:
    print('inherit ' + ' '.join(buildtools))

