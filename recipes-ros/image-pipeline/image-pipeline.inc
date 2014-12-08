SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "21da9a0411616c2d24f0462363bb5a2a"
SRC_URI[sha256sum] = "9d58e569d160bc2184e1344b98e14b5b0d503236d8fc52cdb7a91fd0ef7ac667"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_pipeline"
