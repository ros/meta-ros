SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "52a9730cc9d6e3b9480c2e80cbb9dd2a"
SRC_URI[sha256sum] = "bb8b8df8df4c8c2055518dbe2963d1b587db61def31eeb0d63e4f20811b87d73"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "navigation"
