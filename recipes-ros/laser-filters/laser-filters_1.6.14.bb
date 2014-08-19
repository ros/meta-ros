DESCRIPTION = "Assorted filters designed to operate on 2D planar laser scanners, which use the \
sensor_msgs/LaserScan type."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "angles filters laser-geometry message-filters pluginlib roscpp sensor-msgs tf"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "4ca45f1df93c382ceaf86646940380bc"
SRC_URI[sha256sum] = "cd8c3fe908956677998061f6b3f812c5a5efa508c88064385ec6fe87cb041aec"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
