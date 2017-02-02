SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "0dbcd5a3154947fdf63476b90b421ab0"
SRC_URI[sha256sum] = "e0d5c01e160ceb82aa8c394d40b9f39deb1f005027eefe1e0d29c0417ae47353"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_common"
