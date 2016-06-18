SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "9539c15475c27e7307097eaa04815744"
SRC_URI[sha256sum] = "9537246f167dcb1689888be127efd6706e66518583b74bac2d8a4ff6646a7a43"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "vision_opencv"
