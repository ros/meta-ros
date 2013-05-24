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

SRC_URI = "https://github.com/ros/${ROS_BPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_BP}.tar.gz"

SRC_URI[md5sum] = "484049d013eb988d654d610babb63ffa"
SRC_URI[sha256sum] = "7e0bd2ba6e55de92260fe580792b2ba1793c0b71cc1479d0b63cf56368852eb2"

DEPENDS = "console-bridge libpoco"

S = "${WORKDIR}/${ROS_BP}"

inherit catkin
