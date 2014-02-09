SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a61adb53b470542ee936e5d799c85096"
SRC_URI[sha256sum] = "94df38efa01322acc3fba95e89fb793cb46432c418533b13905508d2874af719"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_controllers"
