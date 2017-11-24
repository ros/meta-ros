SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f4621ba05959f67826878f6540182e3e"
SRC_URI[sha256sum] = "5e358bbbd3283e7f6175fbe55b965b8028e81b95ca54c5ae7a551833b7c61d3e"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_pipeline"
