# Copyright (c) 2019 LG Electronics, Inc

ROS_BUILD_TYPE = "catkin"

# "sip" is a build tool.
DEPENDS_append = " sip-native"
DEPENDS_remove = "sip"

RDEPENDS_${PN}_remove = "sip"
