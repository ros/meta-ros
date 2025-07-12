SUMMARY = "Python Ifconfig Wrapper for Unix/Linux/MacOSX"
HOMEPAGE = "https://github.com/ftao/python-ifcfg"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=6;endline=9;md5=0225b6713258a5e30d7e218074b30c15"

SRC_URI[sha256sum] = "5f96ce813c2964cf292429ba683b1278afa80043b11a479d829ce8246546a605"

inherit pypi setuptools3

# Doesn't parse interflace flags from busybox's ifconfig
# and e.g. ros2doctor depends on them being parsed correctly
RDEPENDS:${PN} += "net-tools"
