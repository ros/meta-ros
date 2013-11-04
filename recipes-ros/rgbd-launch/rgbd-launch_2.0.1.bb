DESCRIPTION = "Launch files to open an RGBD device and \
load all nodelets to convert raw depth/RGB/IR streams to depth images, \
disparity images, and (registered) point clouds."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "image-proc nodelet tf"

SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "b0a87630e3d5881eef522d62e03bca8e"
SRC_URI[sha256sum] = "af78d01b8ec114ebaa72b210b5f012d6d7b83a4e0025117eae95ef16a8f53b19"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RRECOMMENDS_${PN} = "depth-image-proc image-proc nodelet tf"
