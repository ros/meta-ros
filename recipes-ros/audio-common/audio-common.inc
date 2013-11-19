SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "26b6b9f852b0e20017c51fc98e229282"
SRC_URI[sha256sum] = "a41c52b337d1117bdcaa60a8a092629f07da9135c8df42954eb2e225a4ad307a"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "audio_common"
