SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "01813574d054e38289b5e9776b5770ca"
SRC_URI[sha256sum] = "8365e9a49040d2379ef04b96d1c55e5a38a6f69b92fe5d28e0e65a2f50eb39c7"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "vision_opencv"
