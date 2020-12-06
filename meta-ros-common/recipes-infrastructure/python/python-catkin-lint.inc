DESCRIPTION = "catkin_lint checks package configurations for the catkin build system of ROS"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3bf8cac017daef7148adc498afdbabf1"
PYPI_PACKAGE = "catkin_lint"

inherit pypi bash-completion

BBCLASSEXTEND = "native nativesdk"

SRC_URI[sha256sum] = "d8a6995e338de94970bcb9d4a9afa7bdf8efbf8bd2a746411778e33bd0eb8274"
