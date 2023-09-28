# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The tuw_ellipses package contains a computer vision library which is able to detect ellipses within images.       The package is able to estimate the pose of the circle related to the ellipse the circle diameter as well as the camera parameter are known.     A dynamic reconfigure interface allows the user to tune the parameter of the system to ones needs.     But be aware that the pose of a projected circle within a image (ellipse) has two solutions and only one is published as TF."
AUTHOR = "Markus Bader <markus.bader@tuwien.ac.at>"
ROS_AUTHOR = "Markus Bader"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "tuw_marker_detection"
ROS_BPN = "tuw_ellipses"

ROS_BUILD_DEPENDS = " \
    cmake-modules \
    cv-bridge \
    dynamic-reconfigure \
    image-geometry \
    image-transport \
    libeigen \
    marker-msgs \
    nodelet \
    roscpp \
    rospy \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    cv-bridge \
    dynamic-reconfigure \
    image-geometry \
    image-transport \
    marker-msgs \
    nodelet \
    roscpp \
    rospy \
    tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cv-bridge \
    dynamic-reconfigure \
    image-geometry \
    image-transport \
    marker-msgs \
    nodelet \
    roscpp \
    rospy \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tuw-robotics/tuw_marker_detection-release/archive/release/melodic/tuw_ellipses/0.1.1-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/tuw_ellipses"
SRC_URI = "git://github.com/tuw-robotics/tuw_marker_detection-release;${ROS_BRANCH};protocol=https"
SRCREV = "366475740e774206b386776564a056d018172e9e"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
