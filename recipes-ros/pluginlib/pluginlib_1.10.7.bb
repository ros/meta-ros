DESCRIPTION = "The pluginlib package provides tools for writing and dynamically loading plugins \
using the ROS build infrastructure."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost class-loader rosconsole roslib libtinyxml"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e767bf812d74a115efb5855147e2899b"
SRC_URI[sha256sum] = "88f7c45b6a27b8d890daa897974b0501458afcc253149c0523554c7f9b80be3b"

inherit catkin

# libclass_loader.so: error: undefined reference to 'pthread_mutexattr_destroy', 'pthread_mutexattr_settype', 'pthread_mutexattr_init'
LDFLAGS_append = "${@bb.utils.contains('DISTRO_FEATURES', 'ld-is-gold', ' -fuse-ld=bfd ', '', d)}"
