# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "This package contains all messages that are particular to our Active Scene Recognition - Framework at  		Humanoids and Intelligence Systems Lab (HIS), Karlsruhe Institute of Technology (KIT). 	  These messages make up the interfaces between the different collaborating components of this system. 	  They are of critical importance and structured by the ROS communication capabilities."
AUTHOR = "Meißner Pascal <asr-ros@lists.kit.edu>"
ROS_AUTHOR = "Kleinert Daniel, Meißner Pascal, Yi Xie"
HOMEPAGE = "http://ros.org/wiki/asr_msgs"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=248753b20efa0fba3453f8269027e68c"

ROS_CN = "asr_msgs"
ROS_BPN = "asr_msgs"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    message-generation \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    message-runtime \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    message-runtime \
    sensor-msgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/asr-ros/asr_msgs-release/archive/release/melodic/asr_msgs/1.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/asr_msgs"
SRC_URI = "git://github.com/asr-ros/asr_msgs-release;${ROS_BRANCH};protocol=https"
SRCREV = "40843788eb1ecb8497d2ad676d6611f8a0aadc41"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
