SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1e747f99e7bae7a49cb387ac02133534"
SRC_URI[sha256sum] = "03417c24017e912a683f2e6034624673e011de0843a61905b1f8dc7c2745d21e"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_common"
