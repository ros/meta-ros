SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "35f122a7a9ba3d1e7c4addfe01ffcad6"
SRC_URI[sha256sum] = "41e511233510b6d8c73f354c2198c4ff5e82bafa47120fb3ffcb6704a2d7f1a6"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "bond_core"
