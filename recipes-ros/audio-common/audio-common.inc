SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e66d263bef1cd36b89f739b8937fd009"
SRC_URI[sha256sum] = "459ce6d834026969b3bec3fc9d59c446d8bd433661138464b90b9f2df38e6f1c"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "audio_common"
