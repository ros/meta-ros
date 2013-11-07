DESCRIPTION = "This package contains a class for converting from a 2D laser scan as defined by \
  sensor_msgs/LaserScan into a point cloud as defined by sensor_msgs/PointCloud \
  or sensor_msgs/PointCloud2."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "angles boost libeigen sensor-msgs roscpp tf"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "111534440e0b04a1e269b47dcb806753"
SRC_URI[sha256sum] = "63504536e8f28df2baf11f9cc5cec265c92f2a3b1b717af6e8c6bc6c110d15e3"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
