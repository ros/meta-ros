# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "Mobile Robot Programming Toolkit (MRPT) libraries (slam/vision C++ libraries).   This package contains: mrpt-slam, mrpt-vision"
AUTHOR = "Jose-Luis Blanco-Claraco <joseluisblancoc@gmail.com>"
ROS_AUTHOR = "Jose-Luis Blanco-Claraco <joseluisblancoc@gmail.com>"
HOMEPAGE = "https://www.mrpt.org/"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "mrpt_ros"
ROS_BPN = "mrpt_libslam"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-liboctomap-dev} \
    ${ROS_UNRESOLVED_DEP-libopenni2-dev} \
    ament-cmake \
    assimp \
    cv-bridge \
    ffmpeg \
    freeglut \
    glfw \
    jpeg \
    libfreenect \
    libpcap \
    libtinyxml2 \
    libusb1 \
    libxrandr \
    libxxf86vm \
    mesa \
    mrpt-libmaps \
    opencv \
    pkgconfig \
    python3-pip \
    python3-pybind11 \
    rclcpp \
    ros-environment \
    rosbag2-storage \
    tbb \
    udev \
    wxwidgets \
    zlib \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    mrpt-libmaps \
    tbb \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    mrpt-libmaps \
    tbb \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/mrpt_ros-release/archive/release/jazzy/mrpt_libslam/2.14.7-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/mrpt_libslam"
SRC_URI = "git://github.com/ros2-gbp/mrpt_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "21240a74dab988e8a1bb1d8318c2974c1e3c0150"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
