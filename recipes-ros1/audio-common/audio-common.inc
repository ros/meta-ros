SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e57a9204dee30f7c8428f2669c8b8a73"
SRC_URI[sha256sum] = "7d146861d4e4e3b687fee2d86eeb9c337e93fcea94fc65fe3ee9c886e248a181"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "audio_common"
