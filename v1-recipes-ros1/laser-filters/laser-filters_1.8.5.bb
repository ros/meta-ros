DESCRIPTION = "Assorted filters designed to operate on 2D planar laser scanners, which use the \
sensor_msgs/LaserScan type."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "angles filters laser-geometry message-filters pluginlib roscpp sensor-msgs tf"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a4e3aaf40b35a6ffeb60a3a64a11fdc8"
SRC_URI[sha256sum] = "ec7157eefb087a9785736973f93afaf0f5ff340b8c826a775125368c63515c88"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
