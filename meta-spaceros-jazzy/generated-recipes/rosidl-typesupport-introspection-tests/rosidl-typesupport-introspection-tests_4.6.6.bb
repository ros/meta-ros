# Recipe created by ros-generate
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit ros_generate_generated

DESCRIPTION = "Integration tests of the rosidl_typesupport_introspection_c/cpp packages."
AUTHOR = "Aditya Pande <aditya.pande@openrobotics.org>"
ROS_AUTHOR = "Geoffrey Biggs <gbiggs@killbots.net>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=49401288ac6eefb30ad3d3483b395395"

ROS_CN = "rosidl"
ROS_BPN = "rosidl_typesupport_introspection_tests"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gtest\
    ament-lint-auto\
    ament-lint-common\
    rcutils\
    rcpputils\
    rosidl-cmake\
    rosidl-generator-c\
    rosidl-generator-cpp\
    rosidl-typesupport-introspection-c\
    rosidl-typesupport-introspection-cpp\
    rosidl-typesupport-interface\
    test-interface-files\
    service-msgs\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=jazzy"
SRC_URI = "git://github.com/ros2/rosidl.git;${ROS_BRANCH};protocol=https"
SRCREV = "e195b27ae62ea4de7b97fa3a7f984812c73fef34"
S = "${WORKDIR}/git/rosidl_typesupport_introspection_tests"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
