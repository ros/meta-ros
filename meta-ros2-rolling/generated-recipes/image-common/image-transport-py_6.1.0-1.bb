# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Python API for image_transport"
AUTHOR = "Alejandro Hernández <alejandro@openrobotics.org>"
ROS_AUTHOR = "Tamas Foldi"
HOMEPAGE = "https://github.com/ros-perception/image_common"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "image_common"
ROS_BPN = "image_transport_py"

ROS_BUILD_DEPENDS = " \
    image-transport \
    pybind11-vendor \
    python3 \
    rclcpp \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-python-native \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = " \
    image-transport \
    rclcpp \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    image-transport \
    rclcpp \
    rpyutils \
    sensor-msgs \
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

# matches with: https://github.com/ros2-gbp/image_common-release/archive/release/rolling/image_transport_py/6.1.0-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/image_transport_py"
SRC_URI = "git://github.com/ros2-gbp/image_common-release;${ROS_BRANCH};protocol=https"
SRCREV = "bebb947556fdbada87f686bc541a68dfd55623cd"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}