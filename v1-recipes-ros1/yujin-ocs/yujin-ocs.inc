SRC_URI = "https://github.com/yujinrobot/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "bd996001ff36fc07b470d9695ce81414"
SRC_URI[sha256sum] = "3ecc6a3f59c007921369a7542be69121801635421dcedab2528d4298f339f838"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "yujin_ocs"
