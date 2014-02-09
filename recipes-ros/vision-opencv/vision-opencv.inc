SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f2fdc9299ca0b6507137df185f9b5553"
SRC_URI[sha256sum] = "c4934eee07961e194143885751c919137baf77a08d40013dd903da50dfd60b9b"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "vision_opencv"
