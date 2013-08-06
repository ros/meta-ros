SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d77988921c0ca1bf2bda80fa73af14fa"
SRC_URI[sha256sum] = "984d922cb984d00a97264fbf271c017c68db9f0f9d72b8d96344ab8a417c1c2b"

SRC_URI += "file://0001-check-for-CATKIN_ENABLE_TESTING.patch;patchdir=.."

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "diagnostics"
