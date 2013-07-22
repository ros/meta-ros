SRC_URI = "https://github.com/ros/nodelet_core/archive/${PV}.tar.gz;downloadfilename=${BP}.tar.gz"
SRC_URI[md5sum] = "840b98ace89034029569f20a2a41af05"
SRC_URI[sha256sum] = "4cc5a76ec90b0610b794128509923beba9b6dee2cb18fdeb6fd3ecc409051262"

S = "${WORKDIR}/nodelet_core-${PV}/${ROS_BPN}"

inherit catkin
