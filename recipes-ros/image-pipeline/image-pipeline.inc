SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "20619df602ed8be775ca441166f05600"
SRC_URI[sha256sum] = "c204c7ad095b9a2378c00d37e5635388120658658c4bf9511d4bac91fda586e1"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_pipeline"
