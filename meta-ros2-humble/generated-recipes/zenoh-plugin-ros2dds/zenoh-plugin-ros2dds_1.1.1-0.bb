# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "A Zenoh plug-in for ROS2 with a DDS RMW. See https://discourse.ros.org/t/ros-2-alternative-middleware-report/ for the advantages of using this plugin over other DDS RMW implementations."
AUTHOR = "Mark Choi <afewgoodman.choi@gmail.com>"
HOMEPAGE = "https://github.com/eclipse-zenoh/zenoh-plugin-ros2dds"
SECTION = "devel"
LICENSE = "EPL-2.0 & Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=795d413315082484b70ff4d8370975a5"

ROS_CN = "zenoh_bridge_ros2dds"
ROS_BPN = "zenoh_bridge_ros2dds"

ROS_BUILD_DEPENDS = " \
    cargo \
"

#pip install tomli using for hosttool for python 3.11-alpha3 below.
ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    rust-llvm-native \
    clang-native \
    python3-tomli-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/eclipse-zenoh/zenoh-plugin-ros2dds/archive/refs/tags/1.1.1.zip
ROS_BRANCH ?= "branch=release/1.1.1"
SRC_URI = "git://github.com/eclipse-zenoh/zenoh-plugin-ros2dds;${ROS_BRANCH};protocol=https"
SRCREV = "7d505f1036383c9fa3cb72bff9c96295d4da39ac"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}

inherit cargo cargo-update-recipe-crates

# You can generate it by "bitbake -c update_crates zenoh-plugin-ros2dds"
include ${PN}-crates.inc

export RUST_TARGET_DIR = "${B}"
# https://github.com/zmwangx/rust-ffmpeg-sys/issues/82#issuecomment-2333193160
export BINDGEN_EXTRA_CLANG_ARGS = "--sysroot=${RECIPE_SYSROOT}"

SRC_URI += " \
  file://0001-Replace-objectcopy-to-llvm-objectcopy-cyclors-0.3.3.patch \
"

do_patch () {
  if [ -d ${CARGO_VENDORING_DIRECTORY}/cyclors-0.3.3 ]
    then
    cd ${CARGO_VENDORING_DIRECTORY}/cyclors-0.3.3
    if [ ! -f 0001-Replace-objectcopy-to-llvm-objectcopy-cyclors-0.3.3.patch]
      then
      cp ${WORKDIR}/0001-Replace-objectcopy-to-llvm-objectcopy-cyclors-0.3.3.patch .
      patch -p3 < ${WORKDIR}/0001-Replace-objectcopy-to-llvm-objectcopy-cyclors-0.3.3.patch
    fi
  fi
}
