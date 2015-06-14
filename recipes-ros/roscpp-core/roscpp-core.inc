SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "74e1cc402cd70c6a5db0bbc1c6fdc334"
SRC_URI[sha256sum] = "0bd27394c18c7c79313ebc4eafecc04f88aa54a9d0872357b7123105444edf3a"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "roscpp_core"
