# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Mobile Robot Programming Toolkit (MRPT) version 2.x"
AUTHOR = "Jose-Luis Blanco-Claraco <joseluisblancoc@gmail.com>"
ROS_AUTHOR = "Jose-Luis Blanco-Claraco <joseluisblancoc@gmail.com>"
HOMEPAGE = "https://www.mrpt.org/"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=19;endline=19;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "mrpt2"
ROS_BPN = "mrpt2"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libopenni2-dev} \
    assimp \
    cv-bridge \
    ffmpeg \
    freeglut \
    geometry-msgs \
    glfw \
    jpeg \
    jsoncpp \
    libeigen \
    libfreenect \
    libpcap \
    libtinyxml2 \
    libusb1 \
    libxrandr \
    libxxf86vm \
    nav-msgs \
    octomap \
    opencv \
    pcl-conversions \
    rosbag2-storage \
    sensor-msgs \
    std-msgs \
    stereo-msgs \
    suitesparse-cholmod \
    suitesparse-cxsparse \
    tf2 \
    tf2-msgs \
    udev \
    wxwidgets \
    zlib \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    cv-bridge \
    freeglut \
    geometry-msgs \
    glfw \
    libeigen \
    libxrandr \
    libxxf86vm \
    nav-msgs \
    octomap \
    opencv \
    pcl-conversions \
    rosbag2-storage \
    sensor-msgs \
    std-msgs \
    stereo-msgs \
    suitesparse-cholmod \
    suitesparse-cxsparse \
    tf2 \
    tf2-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cv-bridge \
    freeglut \
    geometry-msgs \
    glfw \
    libeigen \
    libxrandr \
    libxxf86vm \
    nav-msgs \
    octomap \
    opencv \
    pcl-conversions \
    rosbag2-storage \
    sensor-msgs \
    std-msgs \
    stereo-msgs \
    suitesparse-cholmod \
    suitesparse-cxsparse \
    tf2 \
    tf2-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/mrpt2-release/archive/release/humble/mrpt2/2.5.0-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/mrpt2"
SRC_URI = "git://github.com/ros2-gbp/mrpt2-release;${ROS_BRANCH};protocol=https"
SRCREV = "31361076817cd2151e9b00d3e1cbb0bb08b80bd7"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
