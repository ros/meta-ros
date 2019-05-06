SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a9cf52febf87dfc4d2bf3eba1a499a6b"
SRC_URI[sha256sum] = "32a2e07724dec6eaaace21eae006274436d70d40bfe205249438570275c43cac"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_common"
