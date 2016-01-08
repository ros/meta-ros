SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "03ebbcee12e6ca89010d5092144e8734"
SRC_URI[sha256sum] = "999fe6fae3a9dce31ba1d09ab06fcf712a19ae7ab71c21833e814132f7211b11"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "navigation"
