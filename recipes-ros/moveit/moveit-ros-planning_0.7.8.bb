DESCRIPTION = "Planning components of MoveIt that use ROS"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "moveit-core moveit-ros-perception dynamic-reconfigure python-rospkg libtinyxml"

require moveit-${PV}.inc

ROS_BPN = "moveit_ros/planning"

SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz \
           file://0001-address-gcc6-build-error.patch \
           "
FILES_${PN} += "${ros_libdir}/moveit_ros_planning/*"
