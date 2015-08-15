SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "334669348ec228aefac50b83bd5e5af1"
SRC_URI[sha256sum] = "1a739aef8ea597f6e7eaad26c031ad90e797efcb9cae764cd352bb124e9744ca"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_common"
