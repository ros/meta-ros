DESCRIPTION = "Object_recognition_msgs contains the ROS message and the actionlib definition used in object_recognition_core"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "message-generation std-msgs geometry-msgs sensor-msgs actionlib-msgs shape-msgs"

SRC_URI = "https://github.com/wg-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c79731da116912ae8b1366aa705345ab"
SRC_URI[sha256sum] = "b7689a079ad78a4358946fa5a38de0c9a5c12e46381d22106f053ac5cde357f1"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
