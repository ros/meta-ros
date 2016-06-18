DESCRIPTION = "Launch files to open an RGBD device and \
load all nodelets to convert raw depth/RGB/IR streams to depth images, \
disparity images, and (registered) point clouds."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "image-proc nodelet tf"

SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "468e3b959050a4f5afda3fd2e8d5b3c5"
SRC_URI[sha256sum] = "f53d02e99514301dd55cb3701b362a9c96ac0d4ab109b1b3b20d3c62de91839b"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RRECOMMENDS_${PN} = "depth-image-proc image-proc nodelet tf"
