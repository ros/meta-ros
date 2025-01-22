# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "Vendor package for: gz-transport13 13.4.0      Gazebo Transport: Provides fast and efficient asynchronous message passing, services, and data logging."
AUTHOR = "Addisu Z. Taddese <addisuzt@intrinsic.ai>"
HOMEPAGE = "https://github.com/gazebosim/gz-transport"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=20;endline=20;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "gz_transport_vendor"
ROS_BPN = "gz_transport_vendor"

ROS_BUILD_DEPENDS = " \
    gz-cmake-vendor \
    gz-math-vendor \
    gz-msgs-vendor \
    gz-tools-vendor \
    gz-utils-vendor \
    pkgconfig \
    protobuf \
    python3 \
    python3-psutil \
    python3-pybind11 \
    python3-pytest \
    sqlite3 \
    util-linux \
    zeromq \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-core-native \
    ament-cmake-test-native \
    ament-cmake-vendor-package-native \
"

ROS_EXPORT_DEPENDS = " \
    gz-cmake-vendor \
    gz-math-vendor \
    gz-msgs-vendor \
    gz-tools-vendor \
    gz-utils-vendor \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    gz-cmake-vendor \
    gz-math-vendor \
    gz-msgs-vendor \
    gz-tools-vendor \
    gz-utils-vendor \
    pkgconfig \
    protobuf \
    python3 \
    python3-psutil \
    python3-pybind11 \
    python3-pytest \
    sqlite3 \
    util-linux \
    zeromq \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-copyright \
    ament-cmake-lint-cmake \
    ament-cmake-xmllint \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/gz_transport_vendor-release/archive/release/jazzy/gz_transport_vendor/0.0.5-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/gz_transport_vendor"
SRC_URI = "git://github.com/ros2-gbp/gz_transport_vendor-release;${ROS_BRANCH};protocol=https"
SRCREV = "507e93357bfe90f8a3a4c11a3e09fbbd3fa501fc"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}