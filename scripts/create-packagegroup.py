#!/usr/bin/env python
#
# Copyright (c) 2013 Stefan Herbrechtsmeier, Bielefeld University
# 
#
# Permission is hereby granted, free of charge, to any person obtaining a copy
# of this software and associated documentation files (the "Software"), to
# deal in the Software without restriction, including without limitation the
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
import httplib
import re

name = 'ros_comm'

if len(sys.argv) > 1:
    name = sys.argv[1]

conn = httplib.HTTPConnection('packages.ros.org')
conn.request('GET', '/web/rosinstall/generate/raw/groovy/' + name)
res = conn.getresponse()
data = res.read()
conn.close()

packages = []
for p in re.findall('local-name:.(\w+)' ,data):
    packages.append(p.replace('_', '-'))

name = name.replace('_', '-')

print('packagegroup-' + name + '.bb')
print('')
print('DESCRIPTION = "' + name + ' package group"');
print('LICENSE = "MIT"')
print('')
print('inherit packagegroup')
print('')
print('PACKAGES = "${PN}"')
print('')
print('RDEPENDS_${PN} = "\\\n    ' + ' \\\n    '.join(packages) + ' \\\n    "')
