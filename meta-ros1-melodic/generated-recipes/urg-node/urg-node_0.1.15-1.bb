# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "urg_node"
AUTHOR = "Tony Baltovski <tony.baltovski@gmail.com>"
ROS_AUTHOR = "Chad Rockey <chadrockey@gmail.com>"
HOMEPAGE = "http://ros.org/wiki/urg_node"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "urg_node"
ROS_BPN = "urg_node"

ROS_BUILD_DEPENDS = " \
    diagnostic-updater \
    dynamic-reconfigure \
    laser-proc \
    message-generation \
    nodelet \
    rosconsole \
    roscpp \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf \
    urg-c \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    diagnostic-updater \
    dynamic-reconfigure \
    laser-proc \
    message-generation \
    nodelet \
    rosconsole \
    roscpp \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf \
    urg-c \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    diagnostic-updater \
    dynamic-reconfigure \
    laser-proc \
    message-generation \
    message-runtime \
    nodelet \
    rosconsole \
    roscpp \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf \
    urg-c \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslaunch \
    roslint \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/urg_node-release/archive/release/melodic/urg_node/0.1.15-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/urg_node"
SRC_URI = "git://github.com/ros-gbp/urg_node-release;${ROS_BRANCH};protocol=https"
SRCREV = "72b4fcbcceca140c32e72280ef947ca5bcde64eb"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
