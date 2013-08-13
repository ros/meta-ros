SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "26ad8652a18bc11b530b0054bbb204b3"
SRC_URI[sha256sum] = "ae3b8db6bf26867c38b1215e1e014616f00a396847fea31df64da63d2eac6ef2"

SRC_URI += "file://0001-resolve-rosunit-path-in-installspace-at-runtime-with.patch;patchdir=../.."

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros"
