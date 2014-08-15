SRC_URI = "https://github.com/bmwcarit/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "350c87a343c6657bc1516b4c7437a6c0"
SRC_URI[sha256sum] = "2c6f17e4f84ef0f9663d0ced05417501dc770961951e4cd13871b75adbb8c72a"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_realtime_tests"
