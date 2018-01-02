DESCRIPTION = "The class_loader package is a ROS-independent package for loading plugins \
during runtime and the foundation of the higher level ROS "pluginlib" library. \
class_loader utilizes the host operating system's runtime loader to open \
runtime libraries (e.g. .so/.dll files), introspect the library for exported \
plugin classes, and allows users to instantiate objects of said exported \
classes without the explicit declaration (i.e. header file) for those classes."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "cmake-modules console-bridge poco"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "3684301f5f1e8c901391e929564b9743"
SRC_URI[sha256sum] = "fb58efe5ec10597770d32f67093976d1522b0e09dfa1b2b9ba1191081421ba49"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
