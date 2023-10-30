# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "urg_node"
AUTHOR = "Michael Ferguson <mfergs7@gmail.com>"
ROS_AUTHOR = "Chad Rockey <chadrockey@gmail.com>"
HOMEPAGE = "http://ros.org/wiki/urg_node"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "urg_node"
ROS_BPN = "urg_node"

ROS_BUILD_DEPENDS = " \
    boost \
    builtin-interfaces \
    diagnostic-updater \
    laser-proc \
    rclcpp \
    rclcpp-components \
    rosidl-default-generators \
    sensor-msgs \
    std-srvs \
    urg-c \
    urg-node-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    builtin-interfaces \
    diagnostic-updater \
    laser-proc \
    rclcpp \
    rclcpp-components \
    rosidl-default-generators \
    sensor-msgs \
    std-srvs \
    urg-c \
    urg-node-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    builtin-interfaces \
    diagnostic-updater \
    laser-proc \
    rclcpp \
    rclcpp-components \
    rosidl-default-generators \
    sensor-msgs \
    std-srvs \
    urdf \
    urg-c \
    urg-node-msgs \
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

# matches with: https://github.com/ros2-gbp/urg_node-release/archive/release/iron/urg_node/1.1.1-3.tar.gz
ROS_BRANCH ?= "branch=release/iron/urg_node"
SRC_URI = "git://github.com/ros2-gbp/urg_node-release;${ROS_BRANCH};protocol=https"
SRCREV = "65dfafa07d60dd139fe03c8e97f8306dd1b41fff"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
