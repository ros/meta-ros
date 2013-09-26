SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "71d4c0694abdde174f419ede8a29d4ee"
SRC_URI[sha256sum] = "ef07479ea4bd4cb7a6ca3225009f1af623fecdd84d1bbc83d982613ca1070cc8"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_transport_plugins"
