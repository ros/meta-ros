SRC_URI = "https://github.com/RobotWebTools/rosbridge_suite/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "0055c9111ef39af379fcf24817a5f0fe"
SRC_URI[sha256sum] = "710021193a87a0da760c9f7124a6abf566b73c4ebb42e0a5eac7738375f80f0b"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "rosbridge_suite"
