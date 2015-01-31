DESCRIPTION = "Frontier exploration implementation in ROS, \
accepts exploration goals via actionlib, sends movement commands to move_base"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=982a0c0253535646914c5d3dde650928"

DEPENDS = "geometry-msgs roscpp pcl costmap-2d actionlib move-base-msgs visualization-msgs tf"

SRC_URI = "https://github.com/paulbovbel/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "dbb1ec9af662a412d18b18827d30757c"
SRC_URI[sha256sum] = "d4b17acdfb6e532df2894a361e5f6636932a05a27f0bdd6052943c27c1371a7d"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RRECOMMENDS_${PN} = "costmap-2d actionlib move-base tf"
