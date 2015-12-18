SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "4cd45df1c6ffa9fea705560e11a51290"
SRC_URI[sha256sum] = "3ce781847f5f855083cfae94a8d89defbe4cc83e086b4c796653561aee08b826"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "vision_opencv"
