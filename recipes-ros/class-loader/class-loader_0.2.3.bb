DESCRIPTION = "\
The class_loader package is a ROS-independent package for loading plugins \
during runtime and the foundation of the higher level ROS "pluginlib" library. \
class_loader utilizes the host operating system's runtime loader to open \
runtime libraries (e.g. .so/.dll files), introspect the library for exported \
plugin classes, and allows users to instantiate objects of said exported \
classes without the explicit declaration (i.e. header file) for those classes.\
"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "console-bridge libpoco"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "fd24802f3cf2e9167561a89be25c24e5"
SRC_URI[sha256sum] = "7279ffe4e7481e71e9c0b6f0dc42e9c6b991100c5d1e7c6034cf28443846de83"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
