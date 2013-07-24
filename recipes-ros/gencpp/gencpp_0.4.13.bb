DESCRIPTION = "C++ ROS message and service generators."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "genmsg-native"

PR = "r1"

SRC_URI = "https://github.com/ros/${BPN}/archive/${PV}.tar.gz;downloadfilename=${BP}.tar.gz \
           file://0001-gencpp-extras.cmake.em-Use-find_program-for-GENCPP_B.patch"
SRC_URI[md5sum] = "801b40dcfab468f761dbdae33f848782"
SRC_URI[sha256sum] = "d1dcd6655c8c4d4325ab067c25284032d40e00aa3409a5a5cf069d310a60d485"

inherit catkin
