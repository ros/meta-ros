DESCRIPTION = "Assorted filters designed to operate on 2D planar laser scanners, which use the \
sensor_msgs/LaserScan type."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "angles filters laser-geometry message-filters pluginlib roscpp sensor-msgs tf"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz \
           file://0001-Use-std-namespace-for-c-11-compat.patch \
           "
SRC_URI[md5sum] = "566b4a51d0d11522d7528ca437c42b0f"
SRC_URI[sha256sum] = "3e124b474c0c0da419366fa21a101874cc7e4c83b352a2da5a21e1967c68555f"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
