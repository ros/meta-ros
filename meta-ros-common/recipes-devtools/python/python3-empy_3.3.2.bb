require python-empy.inc

inherit setuptools3
# The distutils package is deprecated and slated for removal
SRC_URI += " file://0001-setup.py-distutils.core-setuptools.patch"
