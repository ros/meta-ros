SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "77c87b3045771a9875f51000fe075559"
SRC_URI[sha256sum] = "cb6cf4beb4429bc9a5d6502a1865c5dae447a40c09f8188a0253e931e66e5f78"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "robot_model"
