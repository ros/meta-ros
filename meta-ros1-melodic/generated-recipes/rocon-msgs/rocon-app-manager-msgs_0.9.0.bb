# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Messages used by the platform app manager."
AUTHOR = "Daniel Stonier <d.stonier@gmail.com>"
ROS_AUTHOR = "Daniel Stonier"
HOMEPAGE = "http://www.ros.org/wiki/rocon_app_manager_msgs"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=5ee5b8b046ae48ad94a2037ca953a67b"

ROS_CN = "rocon_msgs"
ROS_BPN = "rocon_app_manager_msgs"

ROS_BUILD_DEPENDS = " \
    message-generation \
    rocon-service-pair-msgs \
    rocon-std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    message-runtime \
    rocon-service-pair-msgs \
    rocon-std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    message-runtime \
    rocon-service-pair-msgs \
    rocon-std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/yujinrobot-release/rocon_msgs-release/archive/release/melodic/rocon_app_manager_msgs/0.9.0-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/rocon_app_manager_msgs"
SRC_URI = "git://github.com/yujinrobot-release/rocon_msgs-release;${ROS_BRANCH};protocol=https"
SRCREV = "d6c09aa15eb45f6a3f5c113e901e0f2d49ebaea6"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
