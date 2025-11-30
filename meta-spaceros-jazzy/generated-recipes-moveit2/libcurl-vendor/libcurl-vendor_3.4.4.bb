# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Wrapper around libcurl, it provides a fixed CMake module and an ExternalProject build of it."
AUTHOR = "Alejandro Hernandez Cordero <alejandro@openrobotics.org>"
ROS_AUTHOR = "William Woodall <william@osrfoundation.org>"
HOMEPAGE = "https://github.com/curl/curl"
LICENSE = "Apache-2.0 & MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=f12ef8c0445c08084ae92cf2dcb7ee92"

ROS_CN = "libcurl_vendor"
ROS_BPN = "libcurl_vendor"

ROS_BUILD_DEPENDS = "\
    file\
    curl\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    ament-cmake-vendor-package-native\
"

ROS_EXPORT_DEPENDS = "\
    curl\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = "\
    pkgconfig-native\
"

ROS_EXEC_DEPENDS = "\
    curl\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/libcurl_vendor"
SRC_URI = "git://github.com/ros2-gbp/resource_retriever-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "d80224e4c60400350b1ab8eb61c5f21f89bc1004"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
