DESCRIPTION = "Command line tool to make working with multiple repositories easier"
SUMMARY = "vcs2l provides a command line tool to invoke vcs commands on multiple repositories."
HOMEPAGE = "https://github.com/ros-infrastructure/vcs2l"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7ac031eef55bb823c0c5d412881bef4b"

SRC_URI[sha256sum] = "1d86e685f9e01dda271b89df1b2bd42ca5555f5c0dcbef5cc727d443f25738cd"

inherit pypi setuptools3

# Uncomment this line to enable all the optional features.
#PACKAGECONFIG ?= "python-version-smaller-3-dot-7 python-version-smaller-3-dot-8andpython-version-bigger--equals-3-dot-7 docs test"
PACKAGECONFIG[python-version-smaller-3-dot-7] = ",,,python3-setuptools"
PACKAGECONFIG[python-version-smaller-3-dot-8andpython-version-bigger--equals-3-dot-7] = ",,,python3-importlib_metadata"
PACKAGECONFIG[docs] = ",,,python3-sphinx python3-sphinx-rtd-theme"
PACKAGECONFIG[test] = ",,,python3-pytest"

RDEPENDS:${PN} += "python3-pyyaml"

RDEPENDS:${PN} += "python3-compression python3-core python3-importlib-metadata python3-io python3-logging python3-multiprocessing python3-pyyaml python3-threading python3-xml"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    pkg_resources

PYPI_PACKAGE = "vcs2l"

FILES:${PN} += "${datadir}/vcs2l-completion"

BBCLASSEXTEND = "native nativesdk"
