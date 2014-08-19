DESCRIPTION = "The actionlib stack provides a standardized interface for interfacing with \
preemptable tasks."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "actionlib-msgs roscpp"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "2e13067c3c85e81a3ab4b603ff15e45b"
SRC_URI[sha256sum] = "f71df286552e6bf3a03ef83635342d3bdd6eef836e7b0565dccd2d341dbeaa11"

SRC_URI += "file://0001-make-rostest-in-CMakeLists-optional-ros-rosdistro-30.patch"

inherit catkin
