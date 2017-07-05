SRC_URI = "https://github.com/RobotWebTools/rosbridge_suite/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "0d6f3f4b6f58ecd5e3657962627e4807"
SRC_URI[sha256sum] = "f156cab48fe88bde0d1768481a52ae983d03bf5d990a9a46cd06229447462ad2"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "rosbridge_suite"
