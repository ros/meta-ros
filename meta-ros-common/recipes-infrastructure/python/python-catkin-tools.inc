DESCRIPTION = "Command line tools for working with catkin"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=10;endline=10;md5=9a6ea5b6c346a830f54cc95f6a2a9245"
PYPI_PACKAGE = "catkin_tools"

inherit pypi

BBCLASSEXTEND = "native nativesdk"

SRC_URI[sha256sum] = "8a8e9482b5b03dcfe87a9e3cf9fd6d5937564b49ab71ebc99f71061faf72605b"

# /usr/share/zsh/site-functions/_catkin
FILES_${PN} += "${datadir}/zsh"
