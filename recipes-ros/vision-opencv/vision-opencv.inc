SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "703067467a45ab258b1a7c504fa29105"
SRC_URI[sha256sum] = "bb1ffa43dfbb6958e82c63513d26ade1a027067dbc969497cb6d51633d5ae37b"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "vision_opencv"
