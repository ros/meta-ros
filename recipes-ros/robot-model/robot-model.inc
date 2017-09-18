SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d08fa124fb63eb93dedfdcb14e63425b"
SRC_URI[sha256sum] = "204c2779c707d8688dfe46c29664b5ee210313a5eac03815ddbfed1cfd2c594a"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "robot_model"
