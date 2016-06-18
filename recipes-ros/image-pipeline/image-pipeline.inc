SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "cb3ee1fb6c30d9fd391e0fa864d2ac25"
SRC_URI[sha256sum] = "af0d7e43de48457ca591c4908d5771c116d2838b4bc64fbe49efaa371f44b5b4"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_pipeline"
