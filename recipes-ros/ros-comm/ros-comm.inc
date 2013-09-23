SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "098494e9d10b42ac37a32e595e9d68dc"
SRC_URI[sha256sum] = "6094ab6bd9df197d232825e82a714221fe816a1567495b920917d96f8e271d94"

SRC_URI += "file://0001-rostest-is-optional.patch;patchdir=../.."

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_comm"
