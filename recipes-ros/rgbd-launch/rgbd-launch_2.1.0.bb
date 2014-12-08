DESCRIPTION = "Launch files to open an RGBD device and \
load all nodelets to convert raw depth/RGB/IR streams to depth images, \
disparity images, and (registered) point clouds."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "image-proc nodelet tf"

SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "22077a8d2f2e997f7743cea4ca7fe3e5"
SRC_URI[sha256sum] = "74c1973c10b687339094fa14a6979359beafded55b81362a0861964dd0964b6e"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RRECOMMENDS_${PN} = "depth-image-proc image-proc nodelet tf"
