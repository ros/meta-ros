DESCRIPTION = "Assorted filters designed to operate on 2D planar laser scanners, which use the \
sensor_msgs/LaserScan type."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "angles filters laser-geometry message-filters pluginlib roscpp sensor-msgs tf"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e2d4af91ee2472b76a3a805d6db35998"
SRC_URI[sha256sum] = "a6dff576ea05fb165b7c85cd5eab65970abbd6bb84339f41bad37a89c439492f"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
