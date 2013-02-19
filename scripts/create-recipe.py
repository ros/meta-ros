#!/usr/bin/env python
#
# Copyright (c) 2013 Stefan Herbrechtsmeier, Bielefeld University
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

