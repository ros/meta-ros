#!/usr/bin/env python
#
# Copyright (c) 2013 Lukas Bulwahn, BMW Car IT GmbH
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

info = {'description' : '',
  'license' : '', 'lic_file_beginline' : '', 'lic_file_endline' : '', 'lic_file_md5' : '',
  'url' : '', 'downloadfilename' : '', 'md5sum' : '', 'sha256sum' : '', 'directoryname' : ''}

print '''DESCRIPTION = "%(description)s"
SECTION = "devel"
LICENSE = "%(license)s"
LIC_FILES_CHKSUM = "file://package.xml;beginline=%(lic_file_beginline)s;endline=%(lic_file_endline)s;md5=%(lic_file_md5)s"

SRC_URI = "%(url)s;downloadfilename=%(downloadfilename)s"
SRC_URI[md5sum] = "%(md5sum)s"
SRC_URI[sha256sum] = "%(sha256sum)s"

S = "${WORKDIR}/%(directoryname)s"

DEPENDS = "catkin-native"

inherit cmake pythonnative

''' % info


