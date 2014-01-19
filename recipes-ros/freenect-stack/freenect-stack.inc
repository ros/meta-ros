SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "14841630d9d28e1b20c82993c59951ac"
SRC_URI[sha256sum] = "c921ed369a3ef47ccb6e72ddbdfb3188020adecaa94ad77d28bd58086bf6614c"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "freenect_stack"
