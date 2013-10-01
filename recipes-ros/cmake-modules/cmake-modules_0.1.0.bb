DESCRIPTION = "A common repository for CMake Modules which are not \
distributed with CMake but are commonly used by ROS packages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "988ce2ea80d375eebe36984c39b948d4"
SRC_URI[sha256sum] = "5ba9d987fad3ee781ca1b85af7cc07567b8f955346b4beb2c0b5140cf10b2a16"

SRC_URI += "file://0001-Fix-the-path-added-to-CMAKE_MODULE_PATH.patch;striplevel=1;name=patch"
SRC_URI[patch.md5sum] = "eba3a7eda081516f2113d6db70e881df"
SRC_URI[patch.sha256sum] = "164a8e9d8595856be6a1523fa9ecc0c329961bb89bde2045fefc21306aae6de4"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
