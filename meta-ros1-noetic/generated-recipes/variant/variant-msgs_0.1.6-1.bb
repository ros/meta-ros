# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Variant messages are designed to accommodate the information content of any invariant message. They are truly generic and can freely be converted to and from specific message objects."
AUTHOR = "Samuel Bachmann <sbachmann@anybotics.com>"
ROS_AUTHOR = "Ralf Kaestner <ralf.kaestner@gmail.com>"
HOMEPAGE = "http://github.com/anybotics/variant"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "GNU Lesser General Public License (LGPL)"
LICENSE = "GNU-Lesser-General-Public-License-LGPL-"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=146ba316845cfe6058c8baebd902a726"

ROS_CN = "variant"
ROS_BPN = "variant_msgs"

ROS_BUILD_DEPENDS = " \
    message-generation \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    message-runtime \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    message-runtime \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/anybotics/variant-release/archive/release/noetic/variant_msgs/0.1.6-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/variant_msgs"
SRC_URI = "git://github.com/anybotics/variant-release;${ROS_BRANCH};protocol=https"
SRCREV = "92987134ea28b15f875856851c886f3e5ece3c14"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
