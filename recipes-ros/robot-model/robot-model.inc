SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "3891362268244bb87c9dfee358fc2c2b"
SRC_URI[sha256sum] = "3763a5dfd31f78118358e5c93dc583884cd76055fb5ed3772c3d3ffa6b27584e"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "robot_model"
