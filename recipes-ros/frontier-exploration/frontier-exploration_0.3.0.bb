DESCRIPTION = "Frontier exploration implementation in ROS, \
accepts exploration goals via actionlib, sends movement commands to move_base"
SECTION = "devel"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=1e7b3bcc2e271699c77c769685058cbe"

DEPENDS = "geometry-msgs roscpp pcl costmap-2d actionlib move-base-msgs visualization-msgs tf"

SRC_URI = "https://github.com/paulbovbel/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a27eb097cb0fd2b0a381ffae1461e06a"
SRC_URI[sha256sum] = "991a1350ab3daab7665251215105f25fb107ae5b0a0337fbdcd9adea4d7b72d3"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RRECOMMENDS_${PN} = "costmap-2d actionlib move-base tf"
