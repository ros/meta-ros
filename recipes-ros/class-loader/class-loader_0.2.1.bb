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

SRC_URI = "https://github.com/ros/${ROS_BPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_BP}.tar.gz;name=archive"
SRC_URI[archive.md5sum] = "e844b2f708946c6245093b30f9f7f3b4"
SRC_URI[archive.sha256sum] = "93347aca95be80e78253b964f363cd5486fbf17cf939d224b46ed1de8287679d"

SRC_URI += "https://github.com/ros/class_loader/commit/384a880d2dcf1bc51fe62d5c4648756b4575dba3.patch;name=patch"
SRC_URI[patch.md5sum] = "c95550a5b8197338e57be732b9fa2225"
SRC_URI[patch.sha256sum] = "9029530d2a62c44e1614483ec312572d7cfa47298c4392b066f802c0454a97bf"


DEPENDS = "console-bridge libpoco"

S = "${WORKDIR}/${ROS_BP}"

inherit catkin
