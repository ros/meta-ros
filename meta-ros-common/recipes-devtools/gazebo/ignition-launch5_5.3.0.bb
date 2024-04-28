# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-launch.git;protocol=https;branch=ign-launch5"

SRCREV = "894e2e2319617fbde652960b847e13436391ec9c"

S = "${WORKDIR}/git"

# NOTE: unable to map the following CMake package dependencies: ignition-cmake2
# NOTE: the following library dependencies are unknown, ignoring: bfd dwarf
#       (this is based on recipes that have previously been built and packaged)
DEPENDS = "elfutils"

inherit cmake
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], '', 'cmake_qt5', d)}

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

DEPENDS = " \
    elfutils \
    ignition-cmake2 \
    ignition-common4 \
    ignition-gazebo6 \
    ignition-gui6 \
    ignition-math6 \
    ignition-msgs8 \
    ignition-plugin \
    ignition-rendering6 \
    ignition-tools1 \
    ignition-transport11 \
    ignition-utils1 \
    libwebsockets \
"
