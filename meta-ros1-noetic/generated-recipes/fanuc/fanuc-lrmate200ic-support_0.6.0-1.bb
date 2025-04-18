# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "<p>       ROS-Industrial support for the Fanuc LR Mate 200iC (and variants).     </p>     <p>       This package contains configuration data, 3D models and launch files       for Fanuc LR Mate 200iC manipulators. This includes the base model       (/5C, /5WP), /5H, /5L (/5LC), /5F and the /5HS. Variants in brackets       are supported by the files for the referenced model.     </p>     <p><b>Specifications</b>:</p>     <ul>       <li>LR Mate 200iC    - &quot;J1 - Normal Range&quot;</li>       <li>LR Mate 200iC/5H - &quot;J1 - Normal Range&quot;</li>       <li>LR Mate 200iC/5L - &quot;J1 - Normal Range&quot;</li>       <li>LR Mate 200iC/5F - &quot;J1 - Normal Range&quot;</li>     </ul>     <p>       Joint limits and maximum joint velocities are based on the information in       the <em>FANUC Robot LR Mate 200iC Mechanical Unit Operator's Manual</em>       version <em>B-82584EN/07</em>. All urdfs are based on the default motion       and joint velocity limits, unless noted otherwise (ie: no support for       high speed joints, extended / limited motion ranges or other options).     </p>     <p>       Before using any of the configuration files and / or meshes included       in this package, be sure to check they are correct for the particular       robot model and configuration you intend to use them with.     </p>"
AUTHOR = "G.A. vd. Hoorn (TU Delft Robotics Institute) <g.a.vanderhoorn@tudelft.nl>"
ROS_AUTHOR = "G.A. vd. Hoorn (TU Delft Robotics Institute)"
HOMEPAGE = "http://wiki.ros.org/fanuc_lrmate200ic_support"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=38;endline=38;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "fanuc"
ROS_BPN = "fanuc_lrmate200ic_support"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    fanuc-driver \
    fanuc-resources \
    industrial-robot-client \
    joint-state-publisher-gui \
    robot-state-publisher \
    rviz \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslaunch \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-industrial-release/fanuc-release/archive/release/noetic/fanuc_lrmate200ic_support/0.6.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/fanuc_lrmate200ic_support"
SRC_URI = "git://github.com/ros-industrial-release/fanuc-release;${ROS_BRANCH};protocol=https"
SRCREV = "62853ef5fdd4aefebddc3ccb6f9278d0f6d2f5a4"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
