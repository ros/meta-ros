SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "93262ecca39761feb87ec0538217bbb5"
SRC_URI[sha256sum] = "13d434e2d46e13af05398f3cbacffb2c69e2d015f6827d848f799a28d23e816d"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_common"
