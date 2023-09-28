# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "Mobile Robot Programming Toolkit (MRPT) version 2.x"
AUTHOR = "Jose-Luis Blanco-Claraco <joseluisblancoc@gmail.com>"
ROS_AUTHOR = "Jose-Luis Blanco-Claraco <joseluisblancoc@gmail.com>"
HOMEPAGE = "https://www.mrpt.org/"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "mrpt2"
ROS_BPN = "mrpt2"

ROS_BUILD_DEPENDS = " \
    assimp \
    ffmpeg \
    freeglut \
    glfw \
    jpeg \
    libeigen \
    libpcap \
    libusb1 \
    libxrandr \
    libxxf86vm \
    opencv \
    suitesparse-cholmod \
    suitesparse-cxsparse \
    udev \
    wxwidgets \
    zlib \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    assimp \
    ffmpeg \
    freeglut \
    glfw \
    jpeg \
    libeigen \
    libpcap \
    libusb1 \
    libxrandr \
    libxxf86vm \
    opencv \
    suitesparse-cholmod \
    suitesparse-cxsparse \
    udev \
    wxwidgets \
    zlib \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    assimp \
    ffmpeg \
    freeglut \
    glfw \
    jpeg \
    libeigen \
    libpcap \
    libusb1 \
    libxrandr \
    libxxf86vm \
    opencv \
    suitesparse-cholmod \
    suitesparse-cxsparse \
    udev \
    wxwidgets \
    zlib \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/mrpt-ros2-pkg-release/mrpt2-release/archive/release/foxy/mrpt2/2.1.3-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/mrpt2"
SRC_URI = "git://github.com/mrpt-ros2-pkg-release/mrpt2-release;${ROS_BRANCH};protocol=https"
SRCREV = "75bce39d5368c99ef53151b47f4326cf70262186"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
