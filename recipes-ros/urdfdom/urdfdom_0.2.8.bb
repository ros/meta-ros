DESCRIPTION = "The URDF (U-Robot Description Format) library provides core \
data structures and a simple XML parsers for populating the class data \
structures from an URDF file."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b441202ba2d6b14d62026cb18bb960ed"

DEPENDS = "urdfdom-headers console-bridge libtinyxml"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c2332953b8ee7f4dd23684e700fae14e"
SRC_URI[sha256sum] = "a918d3ae4366504a93d6af780ac1e706cdffad4b621a363a9bd53c5fbf32fe21"

SRC_URI += "file://0001-CMakelists-urdf_parser-fix.patch;striplevel=1;name=patch"
SRC_URI[patch.md5sum] = "3f4af4f833044c287e17ba136f5c84c8"
SRC_URI[patch.sha256sum] = "2cace49c2d02dffb4648d8333db2716b21691c69a30fc68a4d10f317ee0d6e4a" 

S = "${WORKDIR}/${ROS_SP}"

inherit ros cmake
