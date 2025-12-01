# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "\
    tf2 is the second generation of the transform library, which lets\
    the user keep track of multiple coordinate frames over time. tf2\
    maintains the relationship between coordinate frames in a tree\
    structure buffered in time, and lets the user transform points,\
    vectors, etc between any two coordinate frames at any desired\
    point in time.\
"
AUTHOR = "Alejandro Hernandez Cordero <alejandro@openrobotics.org>"
ROS_AUTHOR = "Eitan Marder-Eppstein"
HOMEPAGE = "http://www.ros.org/wiki/tf2"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "geometry2"
ROS_BPN = "tf2"

ROS_BUILD_DEPENDS = "\
    rosidl-runtime-cpp\
    builtin-interfaces\
    geometry-msgs\
    rcutils\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    ament-cmake-ros-native\
"

ROS_EXPORT_DEPENDS = "\
    rosidl-runtime-cpp\
    builtin-interfaces\
    geometry-msgs\
    rcutils\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    builtin-interfaces\
    geometry-msgs\
    rcutils\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-google-benchmark\
    ament-cmake-gtest\
    ament-cmake-copyright\
    ament-cmake-cppcheck\
    ament-cmake-cpplint\
    ament-cmake-lint-cmake\
    ament-cmake-uncrustify\
    ament-cmake-xmllint\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=jazzy"
SRC_URI = "git://github.com/ros2/geometry2.git;${ROS_BRANCH};protocol=https"
SRCREV = "ef97ae6e36a2ab3d0377d937a6b452b3a3bc789c"
S = "${UNPACKDIR}/${BB_GIT_DEFAULT_DESTSUFFIX}/tf2"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
