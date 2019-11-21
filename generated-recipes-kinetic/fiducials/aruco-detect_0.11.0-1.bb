# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Fiducial detection based on the aruco library"
AUTHOR = "Jim Vaughan <jimv@mrjim.com>"
ROS_AUTHOR = "Jim Vaughan <jimv@mrjim.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "fiducials"
ROS_BPN = "aruco_detect"

ROS_BUILD_DEPENDS = " \
    cv-bridge \
    dynamic-reconfigure \
    fiducial-msgs \
    image-transport \
    python-cairosvg \
    python-joblib \
    roscpp \
    sensor-msgs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    cv-bridge \
    dynamic-reconfigure \
    fiducial-msgs \
    image-transport \
    python-cairosvg \
    python-joblib \
    roscpp \
    sensor-msgs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cv-bridge \
    dynamic-reconfigure \
    fiducial-msgs \
    image-transport \
    python-cairosvg \
    python-joblib \
    roscpp \
    sensor-msgs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/UbiquityRobotics-release/fiducials-release/archive/release/kinetic/aruco_detect/0.11.0-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a64742b15a9da8983f840e79645df9a8"
SRC_URI[sha256sum] = "4ed049a2ace10a46e759f02b41c346320e95afc213333fab7d778871caa9f4dd"
S = "${WORKDIR}/fiducials-release-release-kinetic-aruco_detect-0.11.0-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('fiducials', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('fiducials', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/fiducials/fiducials_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/fiducials/fiducials-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/fiducials/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/fiducials/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
