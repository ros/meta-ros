SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1cf720ba817ec0db2172d87030c9ad5e"
SRC_URI[sha256sum] = "29e9ea1c4f76188d369ebde8e94adcdf92260bd9f6d766ce533dbd91e40ee356"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "robot_model"
