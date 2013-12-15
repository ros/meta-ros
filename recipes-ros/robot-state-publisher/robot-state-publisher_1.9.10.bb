DESCRIPTION = "This package allows you to publish the state of a robot to tf."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=5ee5b8b046ae48ad94a2037ca953a67b"

DEPENDS = "libeigen kdl-parser rosconsole roscpp rostime sensor-msgs tf tf-conversions"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "69fd00d92a1fe6928d30cd49f3e41fbd"
SRC_URI[sha256sum] = "b2ee50c242508d78685e17819c3bafe22cdd667e9519c5f107169a9e1507a501"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
