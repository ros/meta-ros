# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "A package to support MongoDB-based storage and analysis for data from a ROS system, eg. saved messages, configurations etc"
AUTHOR = "Nick Hawes <nickh@robots.ox.ac.uk>"
ROS_AUTHOR = "Chris Burbridge"
HOMEPAGE = "http://www.ros.org/wiki/mongodb_store"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "mongodb_store"
ROS_BPN = "mongodb_store"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    message-generation \
    mongodb \
    mongodb-store-msgs \
    openssl \
    python3-catkin-pkg \
    roscpp \
    rospy \
    rostest \
    std-msgs \
    std-srvs \
    topic-tools \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    mongodb \
    mongodb-store-msgs \
    python3-future \
    python3-pymongo \
    roscpp \
    rospy \
    std-msgs \
    std-srvs \
    topic-tools \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/strands-project-releases/mongodb_store/archive/release/noetic/mongodb_store/0.6.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/mongodb_store"
SRC_URI = "git://github.com/strands-project-releases/mongodb_store;${ROS_BRANCH};protocol=https"
SRCREV = "36f221208aa9e50e8828485dae6a899cbb0d4392"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
