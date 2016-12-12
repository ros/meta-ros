#
# MAVROS -- MAVLink extendable communication node for ROS with proxy for Ground Control Station.
#

SRCBRANCH = "indigo-devel"
SRC_URI = "git://github.com/mavlink/mavros.git;protocol=http;branch=${SRCBRANCH}"
SRCREV = "64031594d569e23ab0ddb50bf9ff195cc4c70336"

S = "${WORKDIR}/git/${ROS_SPN}"

inherit catkin
