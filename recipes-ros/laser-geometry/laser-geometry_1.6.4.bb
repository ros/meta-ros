DESCRIPTION = "This package contains a class for converting from a 2D laser scan as defined by \
sensor_msgs/LaserScan into a point cloud as defined by sensor_msgs/PointCloud \
or sensor_msgs/PointCloud2."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "angles boost libeigen sensor-msgs roscpp tf cmake-modules"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1ee7479b8c5914b4ffae996945121441"
SRC_URI[sha256sum] = "8daf8b8b571ca915d8ccbe517af5e6e69a2083a663c5ba4e89a29aa92a58abdb"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
