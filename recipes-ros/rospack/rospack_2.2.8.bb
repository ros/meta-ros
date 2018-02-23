DESCRIPTION = "ROS Package Tool"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost cmake-modules ${PYTHON_PN}-rospkg-native libtinyxml"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz \
           file://0001-Replaced-references-to-deprecated-Boost.TR1.patch \
           "
SRC_URI[md5sum] = "f415d53b620d35ce674959ac7616d202"
SRC_URI[sha256sum] = "a8fecbe03f9757510fe47137642e39a7c31b823d5bf7fa7890acc1169106b638"

inherit catkin

RDEPENDS_${PN} = "${PYTHON_PN}-rosdep \
                  ${@'python-subprocess' if d.getVar('PYTHON_PN', True) == 'python2' else ''}"
