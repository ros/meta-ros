DESCRIPTION = "Package containing PCL (Point Cloud Library)-related ROS messages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=5ee5b8b046ae48ad94a2037ca953a67b"

DEPENDS = "sensor-msgs"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6fe6f598d54d1b4ccb3ceb4868311519"
SRC_URI[sha256sum] = "b3b6b6568bbdd7a7f1d8f84f44227b34741622ee0dbc6b46bd749ae31ac3fe4d"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
