# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "A simple viewer for ROS image topics. Includes a specialized viewer   for stereo + disparity images."
AUTHOR = "Vincent Rabaud <vincent.rabaud@gmail.com>"
ROS_AUTHOR = "Patrick Mihelich"
HOMEPAGE = "https://index.ros.org/p/image_view/github-ros-perception-image_pipeline/"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "image_pipeline"
ROS_BPN = "image_view"

ROS_BUILD_DEPENDS = " \
    boost \
    camera-calibration-parsers \
    cv-bridge \
    image-transport \
    message-filters \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    std-srvs \
    stereo-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    camera-calibration-parsers \
    cv-bridge \
    image-transport \
    message-filters \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    std-srvs \
    stereo-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    camera-calibration-parsers \
    cv-bridge \
    image-transport \
    message-filters \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    std-srvs \
    stereo-msgs \
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

# matches with: https://github.com/ros2-gbp/image_pipeline-release/archive/release/foxy/image_view/2.2.1-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/image_view"
SRC_URI = "git://github.com/ros2-gbp/image_pipeline-release;${ROS_BRANCH};protocol=https"
SRCREV = "4dd5356ef1ad81c06464058aa1f8231ca7ee1f4d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
