DESCRIPTION = "A common repository for CMake Modules which are not \
distributed with CMake but are commonly used by ROS packages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "8e24844c6c06043b596291be926f9141"
SRC_URI[sha256sum] = "d10ec20fb5997a84513044abb2597ab090ddd4a6cd551b4fd277b2ee4649afcf"

SRC_URI += "file://0001-Fix-the-path-added-to-CMAKE_MODULE_PATH.patch;striplevel=1;name=patch"
SRC_URI[patch.md5sum] = "eba3a7eda081516f2113d6db70e881df"
SRC_URI[patch.sha256sum] = "164a8e9d8595856be6a1523fa9ecc0c329961bb89bde2045fefc21306aae6de4"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
