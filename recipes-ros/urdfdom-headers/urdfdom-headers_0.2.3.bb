DESCRIPTION = "The URDF (U-Robot Description Format) headers provides core \
data structure headers for URDF."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b441202ba2d6b14d62026cb18bb960ed"

SRC_URI = "https://github.com/ros/urdfdom_headers/archive/${PV}.tar.gz;downloadfilename=urdfdom_headers-0.2.3.tar.gz"
SRC_URI[md5sum] = "d8b7dae7e3c19b290cf7d42f50f0cca0"
SRC_URI[sha256sum] = "6b1f27b002c6d897b43ed57988133f40aac093a2a6e84d9bf08ed36a13b401ae"

S = "${WORKDIR}/urdfdom_headers-0.2.3"

inherit cmake
