SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "9083bc555db70ec92f0225877ac0f47b"
SRC_URI[sha256sum] = "43eda1dde34d1126093769e401e63742144e302059d8d4f01f441409daa56b9e"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_common"
