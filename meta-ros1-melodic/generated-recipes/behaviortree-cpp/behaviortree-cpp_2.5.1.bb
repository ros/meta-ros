# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "This package provides a behavior trees core."
AUTHOR = "Michele Colledanchise <michele.colledanchise@gmail.com>"
ROS_AUTHOR = "Michele Colledanchise"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "behaviortree_cpp"
ROS_BPN = "behaviortree_cpp"

ROS_BUILD_DEPENDS = " \
    roslib \
    zeromq \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    roslib \
    zeromq \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    roslib \
    zeromq \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/BehaviorTree/behaviortree_cpp-release/archive/release/melodic/behaviortree_cpp/2.5.1-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/behaviortree_cpp"
SRC_URI = "git://github.com/BehaviorTree/behaviortree_cpp-release;${ROS_BRANCH};protocol=https"
SRCREV = "591bfa9148bdefbd4becd364094dbbe9eeffb11a"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
