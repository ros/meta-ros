SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f561ebda19fa6e737d5f06e49e925be4"
SRC_URI[sha256sum] = "3572418e3149b54493770695e5241584f5daf9e849ab70007b16d4ce848d7e12"

SRC_URI += "file://0001-make-rostest-in-CMakeLists-optional-ros-rosdistro-30.patch;patchdir=../.."

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_comm"
