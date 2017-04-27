DESCRIPTION = "Contains transforms (e.g. differential drive inverse kinematics) for the various types of mobile robot platforms."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "ecl-build ecl-license ecl-errors ecl-geometry ecl-math ecl-formatters ecl-linear-algebra"

SRC_URI = "https://github.com/stonier/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "2a3b92362b366cd2b08188c43a51dcbd"
SRC_URI[sha256sum] = "2b5798d37508600ffc5285c4a4e319cd5ad49cac78ed59b216f033a8e9a8cc2e"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ecl_navigation"
