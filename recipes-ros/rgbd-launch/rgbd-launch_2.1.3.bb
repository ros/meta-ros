DESCRIPTION = "Launch files to open an RGBD device and \
load all nodelets to convert raw depth/RGB/IR streams to depth images, \
disparity images, and (registered) point clouds."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "image-proc nodelet tf"

SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "748ffef5e89fbf970b2a5c0e8bfef7dd"
SRC_URI[sha256sum] = "e1753671dfc01af7fa3220aa33cb893851b20dcfbe9909c9d86afd47ce2f0514"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RRECOMMENDS_${PN} = "depth-image-proc image-proc nodelet tf"
