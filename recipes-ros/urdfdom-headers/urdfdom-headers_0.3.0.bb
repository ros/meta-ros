DESCRIPTION = "The URDF (U-Robot Description Format) headers provides core \
data structure headers for URDF."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b441202ba2d6b14d62026cb18bb960ed"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "02da32d5005cba644d3c6bf3c692e5f1"
SRC_URI[sha256sum] = "f059350cd85fc3b8394ed0c3bd0d4b8d14fa9c8edd09c3ee01881b4711843087"

S = "${WORKDIR}/${ROS_SP}"

inherit cmake ros faulty-solibs

ALLOW_EMPTY_${PN} = "1"
