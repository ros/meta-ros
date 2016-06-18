SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "252417316451147e86d472c2198e5bf9"
SRC_URI[sha256sum] = "04e51b63eb7c08eb65a7189e3dce2fa7f5e4d87fd36c5828f313a250d2b403ed"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_controllers"
