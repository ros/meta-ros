# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "Mobile Robot Programming Toolkit (MRPT) libraries (math C++ libraries).   This package contains: mrpt-math"
AUTHOR = "Jose-Luis Blanco-Claraco <joseluisblancoc@gmail.com>"
ROS_AUTHOR = "Jose-Luis Blanco-Claraco <joseluisblancoc@gmail.com>"
HOMEPAGE = "https://www.mrpt.org/"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "mrpt_ros"
ROS_BPN = "mrpt_libmath"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-liboctomap-dev} \
    ament-cmake \
    assimp \
    cv-bridge \
    ffmpeg \
    freeglut \
    glfw \
    jpeg \
    libeigen \
    libfreenect \
    libpcap \
    libtinyxml2 \
    libusb1 \
    libxrandr \
    libxxf86vm \
    mesa \
    mrpt-libbase \
    opencv \
    openni2 \
    pkgconfig \
    python3-pip \
    python3-pybind11 \
    rclcpp \
    ros-environment \
    rosbag2-storage \
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
    libeigen \
    mrpt-libbase \
    suitesparse-cholmod \
    suitesparse-cxsparse \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    libeigen \
    mrpt-libbase \
    suitesparse-cholmod \
    suitesparse-cxsparse \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/mrpt_ros-release/archive/release/jazzy/mrpt_libmath/2.14.7-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/mrpt_libmath"
SRC_URI = "git://github.com/ros2-gbp/mrpt_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "8189b4266645cb391c3e800625dcdfe1f5eba730"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
