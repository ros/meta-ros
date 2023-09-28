# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The smach viewer is a GUI that shows the state of hierarchical     SMACH state machines. It can visualize the possible transitions     between states, as well as the currently active state and the     values of user data that is passed around between states. The     smach viewer uses the SMACH debugging interface based on     the <a href="http://www.ros.org/wiki/smach_msgs">smach     messages</a> to gather information from running state machines."
AUTHOR = "Jonathan Bohren <jbo@jhu.edu>"
ROS_AUTHOR = "Jonathan Bohren <jbo@jhu.edu>"
HOMEPAGE = "http://ros.org/wiki/smach_viewer"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "executive_smach_visualization"
ROS_BPN = "smach_viewer"

ROS_BUILD_DEPENDS = " \
    rostest \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-python-gi-cairo} \
    ${ROS_UNRESOLVED_DEP-python-gi} \
    graphviz \
    gtk+3 \
    smach-msgs \
    smach-ros \
    wxpython \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-python-gi-cairo} \
    ${ROS_UNRESOLVED_DEP-python-gi} \
    graphviz \
    gtk+3 \
    smach-msgs \
    smach-ros \
    wxpython \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/jbohren/executive_smach_visualization-release/archive/release/noetic/smach_viewer/3.0.1-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/smach_viewer"
SRC_URI = "git://github.com/jbohren/executive_smach_visualization-release;${ROS_BRANCH};protocol=https"
SRCREV = "b7ba452c4d72152523362b250abfdff2e87c24b5"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
