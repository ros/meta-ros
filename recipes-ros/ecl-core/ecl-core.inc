SRC_URI = "https://github.com/stonier/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "625fa08e6e23adb58d9de2caaaf2be08"
SRC_URI[sha256sum] = "ea2e3e8e7572d6e18374b8be3736ce4761ea1f18c6af046af3fe4fcaadfc5285"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ecl_core"
