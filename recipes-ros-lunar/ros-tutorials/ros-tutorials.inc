SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c346b13ae947e5f360c99ba2d8218e4a"
SRC_URI[sha256sum] = "6b122ca4c416fd70849a54db4feaf3d1a42a4b3c03c5d5d36b3d97bbb7a06a14"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_tutorials"
