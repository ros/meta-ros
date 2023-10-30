# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "Depthai filters package"
AUTHOR = "Adam Serafin <adam.serafin@luxonis.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "depthai-ros"
ROS_BPN = "depthai_filters"

ROS_BUILD_DEPENDS = " \
    cv-bridge \
    depthai-ros-msgs \
    image-transport \
    message-filters \
    opencv \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    vision-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

ROS_EXPORT_DEPENDS = " \
    cv-bridge \
    depthai-ros-msgs \
    image-transport \
    message-filters \
    opencv \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    vision-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cv-bridge \
    depthai-ros-msgs \
    image-transport \
    message-filters \
    opencv \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    vision-msgs \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/luxonis/depthai-ros-release/archive/release/iron/depthai_filters/2.8.1-1.tar.gz
ROS_BRANCH ?= "branch=release/iron/depthai_filters"
SRC_URI = "git://github.com/luxonis/depthai-ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "5b127e22e8ef62a964390de195d698edbe1da06c"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
