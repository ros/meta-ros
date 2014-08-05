SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "7610358ec0e87b37321e0391e351f487"
SRC_URI[sha256sum] = "bdffab26cd837b6db65d275dd14de143d1cf056167fc121b213b7403142195c4"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "audio_common"
