SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "482f5caa0af3cd843a5a187c4fc88729"
SRC_URI[sha256sum] = "449ab91f02ce63ac8f3c3c809f6c18a044e8a549d396a0a64b3f592e33b8622f"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_tutorials"
