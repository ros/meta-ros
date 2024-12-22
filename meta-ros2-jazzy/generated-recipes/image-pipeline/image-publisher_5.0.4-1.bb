# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "Contains a node publish an image stream from single image file       or avi motion file."
AUTHOR = "Vincent Rabaud <vincent.rabaud@gmail.com>"
ROS_AUTHOR = "Kei Okada"
HOMEPAGE = "https://index.ros.org/p/image_publisher/github-ros-perception-image_pipeline/"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=19;endline=19;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "image_pipeline"
ROS_BPN = "image_publisher"

ROS_BUILD_DEPENDS = " \
    camera-info-manager \
    cv-bridge \
    image-transport \
    rcl-interfaces \
    rclcpp \
    rclcpp-components \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

ROS_EXPORT_DEPENDS = " \
    camera-info-manager \
    cv-bridge \
    image-transport \
    rcl-interfaces \
    rclcpp \
    rclcpp-components \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    camera-info-manager \
    cv-bridge \
    image-transport \
    rcl-interfaces \
    rclcpp \
    rclcpp-components \
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

# matches with: https://github.com/ros2-gbp/image_pipeline-release/archive/release/jazzy/image_publisher/5.0.4-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/image_publisher"
SRC_URI = "git://github.com/ros2-gbp/image_pipeline-release;${ROS_BRANCH};protocol=https"
SRCREV = "898bddc760b97e838d8edf0f39d97f1bec07049d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
