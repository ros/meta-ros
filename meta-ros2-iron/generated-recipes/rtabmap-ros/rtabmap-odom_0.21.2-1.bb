# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "RTAB-Map's odometry package."
AUTHOR = "Mathieu Labbe <matlabbe@gmail.com>"
ROS_AUTHOR = "Mathieu Labbe"
HOMEPAGE = "https://github.com/introlab/rtabmap_ros/issues"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rtabmap_ros"
ROS_BPN = "rtabmap_odom"

ROS_BUILD_DEPENDS = " \
    cv-bridge \
    image-geometry \
    laser-geometry \
    message-filters \
    nav-msgs \
    pcl-conversions \
    pcl-ros \
    pluginlib \
    rclcpp \
    rclcpp-components \
    rtabmap-conversions \
    rtabmap-msgs \
    rtabmap-util \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = " \
    cv-bridge \
    image-geometry \
    laser-geometry \
    message-filters \
    nav-msgs \
    pcl-conversions \
    pcl-ros \
    pluginlib \
    rclcpp \
    rclcpp-components \
    rtabmap-conversions \
    rtabmap-msgs \
    rtabmap-util \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cv-bridge \
    image-geometry \
    laser-geometry \
    message-filters \
    nav-msgs \
    pcl-conversions \
    pcl-ros \
    pluginlib \
    rclcpp \
    rclcpp-components \
    rtabmap-conversions \
    rtabmap-msgs \
    rtabmap-util \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/introlab/rtabmap_ros-release/archive/release/iron/rtabmap_odom/0.21.2-1.tar.gz
ROS_BRANCH ?= "branch=release/iron/rtabmap_odom"
SRC_URI = "git://github.com/introlab/rtabmap_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "0160b49beb25a8a370fe1a172c8807525ff18023"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
