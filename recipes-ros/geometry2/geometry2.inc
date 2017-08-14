SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "bd0907555fbbab035a03016729a48b7a"
SRC_URI[sha256sum] = "61001913ea7568a513171f57a09f02905918cee0b558baa27f7439fbb79700cb"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "geometry2"
