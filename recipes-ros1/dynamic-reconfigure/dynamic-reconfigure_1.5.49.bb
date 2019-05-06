DESCRIPTION = "This unary stack contains the dynamic_reconfigure package which provides a means to \
change node parameters at any time without having to restart the node."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roscpp std-msgs roslib ${PYTHON_PN}-rospkg"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c8205d14f3084e1dae677bc0812bb769"
SRC_URI[sha256sum] = "873c29fcd1d4731c4d76f29513a7fca87f9262ad9aca064e22423a92294a6121"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RDEPENDS_${PN} = "roslib rosservice"
