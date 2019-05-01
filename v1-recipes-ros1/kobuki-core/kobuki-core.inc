SRC_URI = "https://github.com/yujinrobot/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "2aa8afbfbc61473a541633afa761fac9"
SRC_URI[sha256sum] = "a1fe0af70d9b694354058824fdc53055acd77d60519879d10fbd932f88c7dd04"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "kobuki_core"
