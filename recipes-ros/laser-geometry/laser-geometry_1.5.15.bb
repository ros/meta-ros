DESCRIPTION = "This package contains a class for converting from a 2D laser scan as defined by \
  sensor_msgs/LaserScan into a point cloud as defined by sensor_msgs/PointCloud \
  or sensor_msgs/PointCloud2."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "angles boost libeigen sensor-msgs roscpp tf"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "effc25dcef8c05e68895584ba8d59ca2"
SRC_URI[sha256sum] = "d10f3201720199d2654583c3b2f5b63fe57dcb1ad50ebedbaf8b82f87b9be6d6"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
