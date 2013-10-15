DESCRIPTION = "ROS-ified version of gmapping SLAM."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "30ff92a30cd886165ad358888a1ff32a"
SRC_URI[sha256sum] = "7dca7aa3ce188d2e1d5f6817008e24ee1c26818c040d55a19939737513debcf1"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
