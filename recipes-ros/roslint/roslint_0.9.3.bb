DESCRIPTION = "CMake lint commands for ROS packages"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c9d4f2c2fb75bb0afa07d509792793c1"
SRC_URI[sha256sum] = "59af7dd36387f9dff5e2fe56484f999846b12e8039bfbd7db0848dddcee0fdca"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RDEPENDS_${PN} += "bash"
