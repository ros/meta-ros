SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "724cccac0a381e97df80ef42c2c6dd4f"
SRC_URI[sha256sum] = "a1a42385799a713d1d57bee14bdad5890c8cf5983888ed310d54cdccec64ebba"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "robot_model"
