# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "Graph reasoning for extracting semantic concepts using GNNs"
AUTHOR = "adminpc <josmilrom@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "GPLv3"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=1e7b3bcc2e271699c77c769685058cbe"

ROS_CN = "situational_graphs_reasoning"
ROS_BPN = "situational_graphs_reasoning"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-python3-networkx} \
    ${ROS_UNRESOLVED_DEP-python3-pytorch-pip} \
    ${ROS_UNRESOLVED_DEP-python3-seaborn} \
    ${ROS_UNRESOLVED_DEP-python3-torch-geometric-pip} \
    python3-colorama \
    python3-matplotlib \
    python3-numpy \
    python3-protobuf \
    python3-shapely \
    situational-graphs-datasets \
    situational-graphs-msgs \
    situational-graphs-reasoning-msgs \
    situational-graphs-wrapper \
"

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-python3-networkx} \
    ${ROS_UNRESOLVED_DEP-python3-pytorch-pip} \
    ${ROS_UNRESOLVED_DEP-python3-seaborn} \
    ${ROS_UNRESOLVED_DEP-python3-torch-geometric-pip} \
    python3-colorama \
    python3-matplotlib \
    python3-numpy \
    python3-protobuf \
    python3-shapely \
    situational-graphs-datasets \
    situational-graphs-msgs \
    situational-graphs-reasoning-msgs \
    situational-graphs-wrapper \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-python3-networkx} \
    ${ROS_UNRESOLVED_DEP-python3-pytorch-pip} \
    ${ROS_UNRESOLVED_DEP-python3-seaborn} \
    ${ROS_UNRESOLVED_DEP-python3-torch-geometric-pip} \
    python3-colorama \
    python3-matplotlib \
    python3-numpy \
    python3-protobuf \
    python3-shapely \
    situational-graphs-datasets \
    situational-graphs-msgs \
    situational-graphs-reasoning-msgs \
    situational-graphs-wrapper \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-copyright \
    ament-flake8 \
    ament-pep257 \
    python3-pytest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/situational_graphs_reasoning-release/archive/release/iron/situational_graphs_reasoning/0.0.1-1.tar.gz
ROS_BRANCH ?= "branch=release/iron/situational_graphs_reasoning"
SRC_URI = "git://github.com/ros2-gbp/situational_graphs_reasoning-release;${ROS_BRANCH};protocol=https"
SRCREV = "69ef8fe4c2edc2da036bc987ac115c0092681c2b"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}
