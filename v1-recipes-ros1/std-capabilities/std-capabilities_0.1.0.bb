DESCRIPTION = "Repository of standard capability interfaces."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6b38617620548d973af8c0de66615e95"

SRC_URI = "https://github.com/osrf/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c0ae69fddd03051cba41142349c05b2d"
SRC_URI[sha256sum] = "77cd3d4ab0022929ac4f68be64aad311ccc19b082228629ca7d0315fd088b158"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
