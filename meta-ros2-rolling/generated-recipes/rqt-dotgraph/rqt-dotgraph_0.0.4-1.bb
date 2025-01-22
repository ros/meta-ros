# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "rqt GUI plugin to visualize dot graphs."
AUTHOR = "Alexander Xydes <alexander.l.xydes.civ@us.navy.mil>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "LGPLv3 & CC0"
LICENSE = "LGPL-3.0-only & CC0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=2e6fa114fcf6b71f34d11d461c53139e"

ROS_CN = "rqt_dotgraph"
ROS_BPN = "rqt_dotgraph"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-python3-pyside2} \
    ament-index-python \
    python-qt-binding \
    python3-pyqt5 \
    qt-dotgraph \
    qt-gui-py-common \
    rqt-graph \
    rqt-gui \
    rqt-gui-py \
    std-msgs \
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

# matches with: https://github.com/ros2-gbp/rqt_dotgraph-release/archive/release/rolling/rqt_dotgraph/0.0.4-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/rqt_dotgraph"
SRC_URI = "git://github.com/ros2-gbp/rqt_dotgraph-release;${ROS_BRANCH};protocol=https"
SRCREV = "788cc0d517274033826b8575df2af82af45627c1"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}