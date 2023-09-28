# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "A common repository for CMake Modules which are not distributed with CMake but are commonly used by ROS packages."
AUTHOR = "William Woodall <william@osrfoundation.org>"
ROS_AUTHOR = "William Woodall <william@osrfoundation.org>"
HOMEPAGE = "https://github.com/ros/cmake_modules"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "cmake_modules"
ROS_BPN = "cmake_modules"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/cmake_modules-release/archive/release/noetic/cmake_modules/0.5.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/cmake_modules"
SRC_URI = "git://github.com/ros-gbp/cmake_modules-release;${ROS_BRANCH};protocol=https"
SRCREV = "633207b199bbebd18b5014431a7d77f180e9218b"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
