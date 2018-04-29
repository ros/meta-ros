SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "72796ec08f77fc581b4e5c7d5578d807"
SRC_URI[sha256sum] = "b0f0e7d605342b841dec1b2ce53a4d57900b96d8d6bb837093e5c2327af1141e"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_control"
