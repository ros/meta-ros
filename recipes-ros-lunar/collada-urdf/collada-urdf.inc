SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "19bcb9966c07ae94cf765f57779b6173"
SRC_URI[sha256sum] = "77c3ec2301418c2a860d64aff46a9d0e30e392e179345623f8d33877eade79b7"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "collada_urdf"
