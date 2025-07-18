# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "RTAB-Map's standalone library. RTAB-Map is a RGB-D SLAM approach with real-time constraints."
AUTHOR = "Mathieu Labbe <matlabbe@gmail.com>"
ROS_AUTHOR = "Mathieu Labbe"
HOMEPAGE = "http://introlab.github.io/rtabmap"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rtabmap"
ROS_BPN = "rtabmap"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-liboctomap-dev} \
    cv-bridge \
    gtsam \
    libg2o \
    libpointmatcher \
    pcl \
    proj \
    qt-gui-cpp \
    sqlite3 \
    zlib \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-liboctomap-dev} \
    cv-bridge \
    gtsam \
    libg2o \
    libpointmatcher \
    pcl \
    qt-gui-cpp \
    sqlite3 \
    zlib \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-liboctomap-dev} \
    cv-bridge \
    gtsam \
    libg2o \
    libpointmatcher \
    pcl \
    qt-gui-cpp \
    sqlite3 \
    zlib \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/introlab/rtabmap-release/archive/release/noetic/rtabmap/0.21.13-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/rtabmap"
SRC_URI = "git://github.com/introlab/rtabmap-release;${ROS_BRANCH};protocol=https"
SRCREV = "bea0573667b2ce752054e52bc715ae4ba22c1e1a"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
