# Recipe created by ros-generate
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit ros_generate_generated

DESCRIPTION = "Generate the type support for C messages."
AUTHOR = "Dharini Dutia <dharini@openrobotics.org>"
ROS_AUTHOR = "Chris Lalancette <clalancette@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rosidl_typesupport"
ROS_BPN = "rosidl_typesupport_c"

ROS_BUILD_DEPENDS = "\
    rosidl-runtime-c\
    rosidl-typesupport-introspection-c\
    rcpputils\
    rcutils\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-ros-native\
"

ROS_EXPORT_DEPENDS = "\
    rosidl-runtime-c\
    rcpputils\
    rcutils\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = "\
    python3-native\
    ament-cmake-core-native\
"

ROS_EXEC_DEPENDS = "\
    ament-index-python\
    rosidl-cli\
    rosidl-generator-c\
    rosidl-pycommon\
    rosidl-typesupport-interface\
    rcpputils\
    rcutils\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-lint-auto\
    ament-lint-common\
    mimick-vendor\
    performance-test-fixture\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=jazzy"
SRC_URI = "git://github.com/ros2/rosidl_typesupport.git;${ROS_BRANCH};protocol=https"
SRCREV = "dc851e02da9301718c22bf22bda7398fb41d4754"
S = "${WORKDIR}/git/rosidl_typesupport_c"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
