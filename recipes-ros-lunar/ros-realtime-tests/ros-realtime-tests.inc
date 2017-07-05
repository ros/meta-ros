SRC_URI = "https://github.com/bmwcarit/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e9724fb9ea7b4b79cc3bff37dc3e746f"
SRC_URI[sha256sum] = "073ce024a30bc4c340a0be8e6dee731cd8fc2a7dd124e2d7062e523877988063"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_realtime_tests"
