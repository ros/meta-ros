# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "<p>       ROS-Industrial support for the Fanuc CR-7iA (and variants).     </p>     <p>       This package contains configuration data, 3D models and launch files       for Fanuc CR-7iA manipulators. This currently includes the base and       /L model.     </p>     <p><b>Specifications</b>:</p>     <ul>       <li>CR-7iA - Normal Range</li>       <li>CR-7iA/L - Normal Range</li>     </ul>     <p>       Link lengths are based on information in <em>FANUC Robot CR-4iA, CR-7iA,       CR-7iA/L, CR-14iA/L Mechanical Unit Operator's Manual</em> version       <em>B-83774EN/04</em>.       Joint limits and maximum joint velocities are based on the information in       the system variables of the supported variants (either from FRVCs or real       controllers).       All urdfs are based on the default motion and joint velocity limits,       unless noted otherwise (ie: no support for high speed joints,       extended / limited motion ranges or other options).     </p>     <p>       Before using any of the configuration files and / or meshes included       in this package, be sure to check they are correct for the particular       robot model and configuration you intend to use them with.     </p>     <p>       <b>Note</b>: collaborative robots make use of special safety systems       embedded in the OEM controller which continuously monitor the state of       the robot and adapt limits where and when necessary.       The joint limits specified in the xacros provided by this package are the       maximum joint limits as specified by Fanuc. As there is no information       available on how the collaborative safety system works, we cannot model       it here and thus it's very likely the joint limits in these files are       unattainable by the actual robot.     </p>"
AUTHOR = "G.A. vd. Hoorn (TU Delft Robotics Institute) <g.a.vanderhoorn@tudelft.nl>"
ROS_AUTHOR = "Dave Niewinski <dniewinski@clearpathrobotics.com>"
HOMEPAGE = "http://wiki.ros.org/fanuc_cr7ia_support"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=49;endline=49;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "fanuc"
ROS_BPN = "fanuc_cr7ia_support"

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

# matches with: https://github.com/ros-industrial-release/fanuc-release/archive/release/noetic/fanuc_cr7ia_support/0.6.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/fanuc_cr7ia_support"
SRC_URI = "git://github.com/ros-industrial-release/fanuc-release;${ROS_BRANCH};protocol=https"
SRCREV = "91170a710ebb9db4e61b867f73f54e920d854143"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
