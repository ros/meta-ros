SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "10bbbc1f833666e5c7450e0be9f5bfa4"
SRC_URI[sha256sum] = "05b840899ff43ebd791088df132f9cde2d41cf0f7005571579e89ec215eda5cb"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_control"
