SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f0a79aead8acadaf12f9fee676615860"
SRC_URI[sha256sum] = "c8da1314d18e3da895a89966709c3539ed9fe0fb2d8cfd29ee4d3b138d7b48f4"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "vision_opencv"
