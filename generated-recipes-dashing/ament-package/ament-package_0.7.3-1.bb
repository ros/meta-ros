# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The parser for the manifest files in the ament buildsystem."
AUTHOR = "Dirk Thomas <dthomas@osrfoundation.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=9ed539f6175b7e00bfd99b36cfbcbd73"

ROS_CN = "ament_package"
ROS_BPN = "ament_package"

ROS_BUILD_DEPENDS = " \
    python3-setuptools \
"

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = " \
    python3-setuptools \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    python3-setuptools \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    python3-flake8 \
    python3-pytest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros2-gbp/ament_package-release/archive/release/dashing/ament_package/0.7.3-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "8c48259b48776b1c2759df614422eb1a"
SRC_URI[sha256sum] = "ea4921612a5985843b6ba1801a7d0bb3462f7644498b8b0b23e35de12b37dbe0"
S = "${WORKDIR}/ament_package-release-release-dashing-ament_package-0.7.3-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('ament-package', d)}"
ROS_BUILD_TYPE = "ament_python"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('ament-package', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ament-package/ament-package_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ament-package/ament-package-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ament-package/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ament-package/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
