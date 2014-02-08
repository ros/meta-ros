DESCRIPTION = "A common repository for CMake Modules which are not \
distributed with CMake but are commonly used by ROS packages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "428f2fd70cac67a3a3ccfcc8220894b4"
SRC_URI[sha256sum] = "3e42c825a1aa956ef47dff0fff058320a8253e96c756a870a7c647902d30c875"

SRC_URI += "file://0001-Fix-the-path-added-to-CMAKE_MODULE_PATH.patch;striplevel=1;name=patch"
SRC_URI[patch.md5sum] = "eba3a7eda081516f2113d6db70e881df"
SRC_URI[patch.sha256sum] = "164a8e9d8595856be6a1523fa9ecc0c329961bb89bde2045fefc21306aae6de4"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
