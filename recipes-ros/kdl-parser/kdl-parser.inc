SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "ba652e4666ca8357c5cec743553c681d"
SRC_URI[sha256sum] = "67d07757b98f037fb7ce79f95295a54a843d0e48ee43a9392c20563dee08a6b4"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "kdl_parser"
