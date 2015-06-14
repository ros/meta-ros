SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6c2aff8e7e620027932e3a81e73e5724"
SRC_URI[sha256sum] = "51e5e58e2010f668c136fd6178f83747af643fe5cf170484ce449c7e4e219a4e"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_control"
