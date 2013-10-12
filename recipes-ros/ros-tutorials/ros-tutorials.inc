SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "ffe9605ce71998a19fbacf8e6de978af"
SRC_URI[sha256sum] = "05767cba08c36ece986878aae42141537d149d4fe66d4b67e2c3783c887423d3"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_tutorials"
