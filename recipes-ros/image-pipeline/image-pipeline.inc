SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6bdf2392670501dae0c582c9a2310258"
SRC_URI[sha256sum] = "91f4b2e0d5794917d535a149d08127438e0432496accdbb5c4a97cf495bbd010"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_pipeline"
