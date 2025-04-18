# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "Collection of methods and applications to calibrate multi-sensor-systems, e.g.     camera to LiDAR, LiDAR to LiDAR, and LiDAR to vehicle."
AUTHOR = "Miguel Granero <miguel.granero@iosb.fraunhofer.de>"
ROS_AUTHOR = "Boitumelo Ruf"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "multisensor_calibration"
ROS_BPN = "multisensor_calibration"

ROS_BUILD_DEPENDS = " \
    cv-bridge \
    geometry-msgs \
    image-transport \
    libtinyxml2 \
    multisensor-calibration-interface \
    pcl-conversions \
    pcl-ros \
    qtbase \
    rclcpp \
    rclcpp-components \
    rviz-common \
    sensor-msgs \
    small-gicp-vendor \
    std-msgs \
    tf2 \
    tf2-ros \
    urdf \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    cv-bridge \
    geometry-msgs \
    image-transport \
    libtinyxml2 \
    multisensor-calibration-interface \
    pcl-conversions \
    pcl-ros \
    rclcpp \
    rclcpp-components \
    rviz-common \
    sensor-msgs \
    small-gicp-vendor \
    std-msgs \
    tf2 \
    tf2-ros \
    urdf \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cv-bridge \
    geometry-msgs \
    image-transport \
    libtinyxml2 \
    multisensor-calibration-interface \
    pcl-conversions \
    pcl-ros \
    qtbase \
    rclcpp \
    rclcpp-components \
    rviz-common \
    sensor-msgs \
    small-gicp-vendor \
    std-msgs \
    tf2 \
    tf2-ros \
    urdf \
    visualization-msgs \
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

# matches with: https://github.com/ros2-gbp/multisensor_calibration-release/archive/release/jazzy/multisensor_calibration/2.0.3-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/multisensor_calibration"
SRC_URI = "git://github.com/ros2-gbp/multisensor_calibration-release;${ROS_BRANCH};protocol=https"
SRCREV = "7c887ba2afae013c3f309f2f0f1bd72a2a2f2efb"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
