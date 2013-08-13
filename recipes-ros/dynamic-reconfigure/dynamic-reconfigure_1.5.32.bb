DESCRIPTION = "\
This unary stack contains the dynamic_reconfigure package which provides a means to change \
node parameters at any time without having to restart the node."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=5ee5b8b046ae48ad94a2037ca953a67b"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "9061fd30e5a04e8376eaddffaae86b07"
SRC_URI[sha256sum] = "4203b0a8389d9ac3203110b507d23fa353262cf26253f40abece6418d6c2bdd4"

SRC_URI += "https://github.com/ros/${ROS_SPN}/commit/b7b222534f7259ca457ea354d92c5708f895202e.patch;name=patch"
SRC_URI[patch.md5sum] = "0607963ca3f940362c9e78b5f8019cb9"
SRC_URI[patch.sha256sum] = "e132ed52fe35c287658700857f7d9439793ff2be7f9fa9a19731024152ccaf29"

DEPENDS = "roscpp std-msgs roslib"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RDEPENDS_${PN} = "roslib"
