DESCRIPTION = "This package contains a class for converting from a 2D laser scan as defined by \
sensor_msgs/LaserScan into a point cloud as defined by sensor_msgs/PointCloud \
or sensor_msgs/PointCloud2."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "angles boost libeigen sensor-msgs roscpp tf"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "7ce41e57b1fdedee4bb4d181e7dd150b"
SRC_URI[sha256sum] = "7f3a8a9c2ebf0d93014ff62fc1dd38999945ea1bffb5fe30c7622e8765ea3e5d"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
