SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "7ce8f635b4e56c5802284c27acf7b008"
SRC_URI[sha256sum] = "60e694e8575db93e24a8ed9cbebae8c257f6f25aef33a0e7f92418f318fd9131"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "nodelet_core"
