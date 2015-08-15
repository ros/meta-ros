SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "5e8e4fe8abb410b657eb9a2683d451af"
SRC_URI[sha256sum] = "8e3b756932a821b4387b7f86ca9fc5233ebb2a13541b220b866e42ea6f92b17f"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_pipeline"
