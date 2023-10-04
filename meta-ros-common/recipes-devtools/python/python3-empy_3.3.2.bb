require python-empy.inc

inherit setuptools3

SRC_URI:append = " file://0001-setup.py-switch-from-distutils-to-setuptools.patch "
