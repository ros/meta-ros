SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "537c8dca08fe8a936438252b3ee6cdc8"
SRC_URI[sha256sum] = "2d9b10f1e3c22145d58ba922dcafc72b149bb4561e641fff17eddf1510294271"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_transport_plugins"
