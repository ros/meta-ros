SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "ebae538d0b6b83ee01f749e35343d94f"
SRC_URI[sha256sum] = "a0d31e59f3cd67ae37be980b8e208d7315b483b025b8f01de17757d045ccf111"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_common"
