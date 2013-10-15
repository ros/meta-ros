DESCRIPTION = "Tools for operating on shape messages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=5ee5b8b046ae48ad94a2037ca953a67b"

DEPENDS = "shape-msgs visualization-msgs"

SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "75e12ba67d11470a1028eaf38f792604"
SRC_URI[sha256sum] = "19a11713c78e409a466bca5168a7710e096a92f92fcafef4fa485bc7606eaf3e"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
