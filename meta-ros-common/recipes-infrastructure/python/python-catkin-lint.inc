DESCRIPTION = "catkin_lint checks package configurations for the catkin build system of ROS"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3bf8cac017daef7148adc498afdbabf1"
PYPI_PACKAGE = "catkin_lint"

inherit pypi bash-completion

BBCLASSEXTEND = "native nativesdk"

SRC_URI[sha256sum] = "5d5734ef1271ea0866a527622e36402069c665d0adbdc7193b2ba7ea242475c7"
