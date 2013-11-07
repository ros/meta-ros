SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "8d5fcadd2383832c663a83b5e669e06d"
SRC_URI[sha256sum] = "c95257b963a4e9cba3c3f76c1ca03f3050b5a4736a4b2cda88a5e2282521f1c9"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "vision_opencv"
