DESCRIPTION = "The class_loader package is a ROS-independent package for loading plugins \
during runtime and the foundation of the higher level ROS "pluginlib" library. \
class_loader utilizes the host operating system's runtime loader to open \
runtime libraries (e.g. .so/.dll files), introspect the library for exported \
plugin classes, and allows users to instantiate objects of said exported \
classes without the explicit declaration (i.e. header file) for those classes."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "cmake-modules console-bridge poco"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "faa7b419ba0ea1714f71404c2e76af0a"
SRC_URI[sha256sum] = "4413ea6492bc75a197fa2f219f59e46f70a33dc740aef0fba4f583c3de7bbbc3"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
