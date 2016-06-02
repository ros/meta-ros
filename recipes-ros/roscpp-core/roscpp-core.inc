SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "fa45647beaed9d551775393768bbf8fa"
SRC_URI[sha256sum] = "85028afb1e1630b47890d3c92bcb7edf61f4be04281669f73f000312621bf66d"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "roscpp_core"
