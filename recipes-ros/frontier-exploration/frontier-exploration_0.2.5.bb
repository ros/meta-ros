DESCRIPTION = "Frontier exploration implementation in ROS, \
accepts exploration goals via actionlib, sends movement commands to move_base"
SECTION = "devel"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=1e7b3bcc2e271699c77c769685058cbe"

DEPENDS = "geometry-msgs roscpp pcl costmap-2d actionlib move-base-msgs visualization-msgs tf"

SRC_URI = "https://github.com/paulbovbel/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "05c1be2938dcb998deba340012b5b91a"
SRC_URI[sha256sum] = "a26149014a5ded055f5424d97d3621bcfd7f472fc0664ef61f76ed2f114a6e20"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RRECOMMENDS_${PN} = "costmap-2d actionlib move-base tf"
