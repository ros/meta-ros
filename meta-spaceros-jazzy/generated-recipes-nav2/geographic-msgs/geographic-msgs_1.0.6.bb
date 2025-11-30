# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "ROS messages for Geographic Information Systems."
AUTHOR = "Jack O'Quin <jack.oquin@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/geographic_msgs"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "geographic_msgs"
ROS_BPN = "geographic_msgs"

ROS_BUILD_DEPENDS = "\
    rosidl-default-generators\
    geometry-msgs\
    std-msgs\
    unique-identifier-msgs\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    geometry-msgs\
    std-msgs\
    unique-identifier-msgs\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    rosidl-default-runtime\
    geometry-msgs\
    std-msgs\
    unique-identifier-msgs\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gtest\
    ament-lint-auto\
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

ROS_BRANCH ?= "branch=release/jazzy/geographic_msgs"
SRC_URI = "git://github.com/ros2-gbp/geographic_info-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "caa6354cd98e112a31d8f26ab3168880bb3d327e"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
