# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "DNN based detection"
AUTHOR = "Jim Vaughan <jimv@mrjim.com>"
ROS_AUTHOR = "Jim Vaughan <jimv@mrjim.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "dnn_detect"
ROS_BPN = "dnn_detect"

ROS_BUILD_DEPENDS = " \
    cv-bridge \
    dynamic-reconfigure \
    fiducial-msgs \
    image-transport \
    opencv3 \
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
    opencv3 \
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
    opencv3 \
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

SRC_URI = "https://github.com/UbiquityRobotics-release/dnn_detect-release/archive/release/kinetic/dnn_detect/0.0.3-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "2cef85bf0088d76ea2ab2c36bc142634"
SRC_URI[sha256sum] = "d137392a11d23204fb54890f99d51af09c80214f8fbdb0cf17063aeba1ed22cd"
S = "${WORKDIR}/dnn_detect-release-release-kinetic-dnn_detect-0.0.3-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('dnn-detect', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('dnn-detect', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/dnn-detect/dnn-detect_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/dnn-detect/dnn-detect-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/dnn-detect/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/dnn-detect/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
