SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c1655d3e40d00e5f8c5d4e75d9e1185e"
SRC_URI[sha256sum] = "b610f50cdbab30abaa94980b22a444c5d898c571e3f57f0cf83ecde53877fdf0"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_transport_plugins"
