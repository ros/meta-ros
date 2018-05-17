SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "9aeba8fdc60dcfae346b9f38374da1fa"
SRC_URI[sha256sum] = "2014c8c3466740fbb79dd49d493ad846e5fe6bb551d180afc3ce5b9b47857e95"

DEPENDS += "cpp-common roscpp-serialization message-generation message-runtime std-msgs"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "common_msgs"
