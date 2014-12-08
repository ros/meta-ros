SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "755ed777cf76844952a4cb896a1b5b05"
SRC_URI[sha256sum] = "b0f5a18f09ae6ccbb7cdaed9bebcbdde4dcfa09792c79f81a9afeb9be342b2c9"

DEPENDS += "cpp-common roscpp-serialization message-generation message-runtime std-msgs"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "common_msgs"
