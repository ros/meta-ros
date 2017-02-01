DESCRIPTION = "A common repository for CMake Modules which are not \
distributed with CMake but are commonly used by ROS packages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz \
"
SRC_URI[md5sum] = "c3c2057e022976d89bddd857da028746"
SRC_URI[sha256sum] = "4f9358aab07cdc5455ee0545e6791a47687b6e5f4b8fe11481c168968105b8cb"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
