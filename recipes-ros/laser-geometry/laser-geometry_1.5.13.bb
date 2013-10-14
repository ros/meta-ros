DESCRIPTION = "This package contains a class for converting from a 2D laser scan as defined by \
  sensor_msgs/LaserScan into a point cloud as defined by sensor_msgs/PointCloud \
  or sensor_msgs/PointCloud2."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "angles boost libeigen sensor-msgs roscpp tf"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "dce0a6f2a6a7eeee3913bb01ff8081e1"
SRC_URI[sha256sum] = "8df2f328bc8dfb7c54d89ffbe832c0f2756864d6baddb39d5ea229be9f52b14d"

SRC_URI += "file://0001-check-for-CATKIN_ENABLE_TESTING.patch"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
