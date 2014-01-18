DESCRIPTION = "Python ROS message and service generators."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "genmsg"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "acad2f363723356982368ad69eab5906"
SRC_URI[sha256sum] = "e3d38e5cfb135568470aaa0747f8e7ce8df6f599f7d586790b3c5a8b6058dc4b"

inherit catkin

RDEPENDS_${PN} = "python-math genmsg python-shell"
RDEPENDS_${PN}_class-native = ""
