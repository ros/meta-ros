SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f5b776df0be6a325f8615c8034b1c278"
SRC_URI[sha256sum] = "a3dcd3af617bcafba5b8dab5fbd89183fbaf31798ee4e4e63a91059fa110168c"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_transport_plugins"
