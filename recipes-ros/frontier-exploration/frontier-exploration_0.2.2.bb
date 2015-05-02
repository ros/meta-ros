DESCRIPTION = "Frontier exploration implementation in ROS, \
accepts exploration goals via actionlib, sends movement commands to move_base"
SECTION = "devel"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=1e7b3bcc2e271699c77c769685058cbe"

DEPENDS = "geometry-msgs roscpp pcl costmap-2d actionlib move-base-msgs visualization-msgs tf"

SRC_URI = "https://github.com/paulbovbel/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "dbb1ec9af662a412d18b18827d30757c"
SRC_URI[sha256sum] = "d4b17acdfb6e532df2894a361e5f6636932a05a27f0bdd6052943c27c1371a7d"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RRECOMMENDS_${PN} = "costmap-2d actionlib move-base tf"
