DESCRIPTION = "Package modeling the run-time dependencies for language bindings of messages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "gencpp-native"

SRC_URI = "https://github.com/ros/${ROS_BPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_BP}.tar.gz"
SRC_URI[md5sum] = "10a516326a3bf18f5b5b4523c6e53940"
SRC_URI[sha256sum] = "87f6b56679ea6b90512e2f2d299dd129d361b4a5d167237a9d28ac56ce6f2a36"

S = "${WORKDIR}/${ROS_BPN}-${PV}"

inherit catkin
