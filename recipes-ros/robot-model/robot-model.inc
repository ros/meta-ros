SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "110e76eee2095f98da5248a6dd1d1207"
SRC_URI[sha256sum] = "a43a17e8f19a41fba5660f94eb40e89f2b3fecab81fe8b54f657d430dd936cd4"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "robot_model"
