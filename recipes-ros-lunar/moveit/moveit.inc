SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6b8c169cb96ae4eb4fe3a67acb77915b"
SRC_URI[sha256sum] = "880dd7bf65f82eac3dd87104bd30389fcf8af18790fc15e6597964aec50db5a1"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin ros-insane

ROS_SPN = "moveit"
