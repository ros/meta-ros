DESCRIPTION = "Launch files to open an RGBD device and \
load all nodelets to convert raw depth/RGB/IR streams to depth images, \
disparity images, and (registered) point clouds."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "image-proc nodelet tf"

SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "caeb27d7be3cb124fcf2d988f3c9f5e4"
SRC_URI[sha256sum] = "e9914dd54452ee70e73ea6f9088a63f2a5af0a4baaed4cb2d9edf7031873aafc"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RRECOMMENDS_${PN} = "depth-image-proc image-proc nodelet tf"
