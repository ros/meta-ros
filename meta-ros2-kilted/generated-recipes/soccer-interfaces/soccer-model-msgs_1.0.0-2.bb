# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_kilted
inherit ros_superflore_generated

DESCRIPTION = "A package containing world model related message definitions in the soccer domain."
AUTHOR = "ijnek <kenjibrameld@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "soccer_interfaces"
ROS_BPN = "soccer_model_msgs"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    rosidl-default-generators \
    soccer-geometry-msgs \
    soccer-vision-attribute-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    soccer-geometry-msgs \
    soccer-vision-attribute-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    rosidl-default-runtime \
    soccer-geometry-msgs \
    soccer-vision-attribute-msgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/soccer_interfaces-release/archive/release/kilted/soccer_model_msgs/1.0.0-2.tar.gz
ROS_BRANCH ?= "branch=release/kilted/soccer_model_msgs"
SRC_URI = "git://github.com/ros2-gbp/soccer_interfaces-release;${ROS_BRANCH};protocol=https"
SRCREV = "fa6308a5a20e814bb6f7cc4ab4047893ff409b2c"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
