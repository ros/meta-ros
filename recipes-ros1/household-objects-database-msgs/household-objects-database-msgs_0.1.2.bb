DESCRIPTION = "The household_objects_database_msgs package"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "message-generation std-msgs geometry-msgs shape-msgs object-recognition-msgs"

SRC_URI = "https://github.com/ros-interactive-manipulation/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "96cc5baed4d92626044470772745bf58"
SRC_URI[sha256sum] = "1ab82ef50d580635a7248c83585e641687aa32465c766ebcda5f044778f9ff5b"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
