# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "Wrapper around openeb"
AUTHOR = "Bernd Pfrommer <bernd.pfrommer@gmail.com>"
ROS_AUTHOR = "Bernd Pfrommer <bernd.pfrommer@gmail.com>"
HOMEPAGE = "https://github.com/prophesee-ai/openeb"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=0b6b7b9fa3107761445054a432e198e0"

ROS_CN = "openeb_vendor"
ROS_BPN = "openeb_vendor"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libopenscenegraph} \
    ${ROS_UNRESOLVED_DEP-libusb} \
    boost \
    ffmpeg \
    glew \
    glfw \
    hdf5 \
    libusb1 \
    opencv \
    protobuf \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    ament-cmake-vendor-package-native \
    cmake-native \
    curl-native \
    git-native \
    hdf5-native \
    pkgconfig-native \
    unzip-native \
    wget-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libopenscenegraph} \
    ${ROS_UNRESOLVED_DEP-libusb} \
    boost \
    ffmpeg \
    glew \
    glfw \
    hdf5 \
    libusb1 \
    opencv \
    protobuf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libopenscenegraph} \
    ${ROS_UNRESOLVED_DEP-libusb} \
    boost \
    ffmpeg \
    glew \
    glfw \
    hdf5 \
    libusb1 \
    opencv \
    protobuf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    gtest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/openeb_vendor-release/archive/release/jazzy/openeb_vendor/2.0.1-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/openeb_vendor"
SRC_URI = "git://github.com/ros2-gbp/openeb_vendor-release;${ROS_BRANCH};protocol=https"
SRCREV = "440b6ce21ad76d41afe5c326721b379b6f3e8b06"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
