SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1a15fc5764478d1297417d3ca83ad200"
SRC_URI[sha256sum] = "fba4c223e85923060d76f1113b346207b2d36cda0e2c3393ec96ff99ba918dbe"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "geometry2"
