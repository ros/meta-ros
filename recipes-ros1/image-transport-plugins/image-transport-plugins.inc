SRC_URI = "git://github.com/ros-perception/${ROS_SPN}.git;branch=indigo-devel;protocol=git"
SRCREV = "812093c8342112bca3ac62cccd1188efc453c74b"

S = "${WORKDIR}/git/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_transport_plugins"
