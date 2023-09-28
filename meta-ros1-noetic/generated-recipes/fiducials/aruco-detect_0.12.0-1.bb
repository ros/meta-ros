# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Fiducial detection based on the aruco library"
AUTHOR = "Jim Vaughan <jimv@mrjim.com>"
ROS_AUTHOR = "Jim Vaughan <jimv@mrjim.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "fiducials"
ROS_BPN = "aruco_detect"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-python3-cairosvg} \
    ${ROS_UNRESOLVED_DEP-python3-joblib} \
    compressed-depth-image-transport \
    compressed-image-transport \
    cv-bridge \
    dynamic-reconfigure \
    fiducial-msgs \
    image-transport \
    roscpp \
    sensor-msgs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    theora-image-transport \
    vision-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-python3-cairosvg} \
    ${ROS_UNRESOLVED_DEP-python3-joblib} \
    compressed-depth-image-transport \
    compressed-image-transport \
    cv-bridge \
    dynamic-reconfigure \
    fiducial-msgs \
    image-transport \
    roscpp \
    sensor-msgs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    theora-image-transport \
    vision-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-python3-cairosvg} \
    ${ROS_UNRESOLVED_DEP-python3-joblib} \
    compressed-depth-image-transport \
    compressed-image-transport \
    cv-bridge \
    dynamic-reconfigure \
    fiducial-msgs \
    image-transport \
    roscpp \
    sensor-msgs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    theora-image-transport \
    vision-msgs \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/UbiquityRobotics-release/fiducials-release/archive/release/noetic/aruco_detect/0.12.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/aruco_detect"
SRC_URI = "git://github.com/UbiquityRobotics-release/fiducials-release;${ROS_BRANCH};protocol=https"
SRCREV = "75cf3c9ca5dbd6be9402a7f4e8f6526fda4c0d20"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
