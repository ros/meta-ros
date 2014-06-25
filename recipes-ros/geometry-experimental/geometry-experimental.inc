SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "2e79be808c5b92ebf337849bae94c561"
SRC_URI[sha256sum] = "b9f0a7db4d4b1469c92b1fab1a6f17a0f3018a3e0da437194dc1208453de816d"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "geometry_experimental"
