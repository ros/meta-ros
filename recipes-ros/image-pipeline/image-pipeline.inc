SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "98c520ae51f6fbd6871f79461980111d"
SRC_URI[sha256sum] = "39094733f9d1409ec75702823376f433fe2ccc6a317c2bbcb1c8ebe0d076b8f4"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_pipeline"
