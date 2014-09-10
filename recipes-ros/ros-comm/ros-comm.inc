SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d76ea0a49d8cf5ac21345119a617c60b"
SRC_URI[sha256sum] = "7680d3e14c3dba8d393f7fde21eb2b5ac78d7024ac6fc5b13a653172bf8a2f30"

SRC_URI += "file://0001-make-rostest-in-CMakeLists-optional-ros-rosdistro-30.patch;patchdir=../.."

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_comm"
