# Copyright (c) 2019 LG Electronics, Inc

ROS_BUILD_TYPE = "catkin"

FILESEXTRAPATHS_prepend := "${THISDIR}/python-orocos-kdl:"
SRC_URI += " \
    file://fix-findsip-cmake.patch \
"

# "sip" is a build tool.
DEPENDS_append = " sip-native"
DEPENDS_remove = "sip"

RDEPENDS_${PN}_remove = "sip"
