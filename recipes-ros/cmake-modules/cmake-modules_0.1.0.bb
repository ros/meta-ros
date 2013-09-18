DESCRIPTION = "A common repository for CMake Modules which are not \
distributed with CMake but are commonly used by ROS packages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "988ce2ea80d375eebe36984c39b948d4"
SRC_URI[sha256sum] = "5ba9d987fad3ee781ca1b85af7cc07567b8f955346b4beb2c0b5140cf10b2a16"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
