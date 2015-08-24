SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "64ead6f8535b38eada57366ae9e08021"
SRC_URI[sha256sum] = "0cf0934d4d9bd91e966afc2f25a4e54646016b6628f4fe58e81faee0c58c88c2"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "vision_opencv"
