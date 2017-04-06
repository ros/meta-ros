DESCRIPTION = "Server Side tools for Authorization and Autentication of ROS Clients"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roscpp"

SRC_URI = "https://github.com/WPI-RAIL/rosauth/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "0e165e867239157266aa2e4c192244bf"
SRC_URI[sha256sum] = "c85c4163c94d20bce9864180785210bfe3dfd110114f18212bd711d1be87c48e"

SRC_URI += "file://0001-make-rostest-in-CMakeLists-optional-ros-rosdistro-30.patch"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
