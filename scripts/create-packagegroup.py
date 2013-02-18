#!/usr/bin/env python
#
# Copyright (c) 2013 Stefan Herbrechtsmeier, Bielefeld University
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
