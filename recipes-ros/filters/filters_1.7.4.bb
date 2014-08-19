DESCRIPTION = "This library provides a standardized interface for processing data as a sequence of filters."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roslib rosconsole roscpp pluginlib"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "0dd26504be16afa7816e9a5aa11715f1"
SRC_URI[sha256sum] = "fb71f1fbeaf89726877fce66dce1db8957c5cc6dffa1973d6a104a10233f8237"

SRC_URI += "file://0001-check-for-CATKIN_ENABLE_TESTING.patch; \
    file://0001-make-rostest-in-CMakeLists-optional-ros-rosdistro-30.patch"

inherit catkin
