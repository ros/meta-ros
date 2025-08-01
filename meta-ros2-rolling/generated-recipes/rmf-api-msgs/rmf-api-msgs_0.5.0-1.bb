# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "RMF API msgs definition"
AUTHOR = "Grey <grey@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rmf_api_msgs"
ROS_BPN = "rmf_api_msgs"

ROS_BUILD_DEPENDS = " \
    nlohmann-json \
    python3-jinja2 \
    python3-jsonschema \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    nlohmann-json \
    python3-jinja2 \
    python3-jsonschema \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    nlohmann-json \
    python3-jinja2 \
    python3-jsonschema \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rmf_api_msgs-release/archive/release/rolling/rmf_api_msgs/0.5.0-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/rmf_api_msgs"
SRC_URI = "git://github.com/ros2-gbp/rmf_api_msgs-release;${ROS_BRANCH};protocol=https"
SRCREV = "24f1bb7b676cdc46cbc63156d9930b4bfc590542"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
