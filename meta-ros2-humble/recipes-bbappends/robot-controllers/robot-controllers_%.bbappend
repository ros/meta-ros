# Doesn't need build dependency on orocos-kdl use orocos-kdl-vendor
DEPENDS:remove = "orocos-kdl"
ROS_EXEC_DEPENDS:remove = "orocos-kdl"

DEPENDS += "orocos-kdl-vendor"
ROS_EXEC_DEPENDS += "orocos-kdl-vendor"
