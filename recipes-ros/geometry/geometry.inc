SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "32fd3bf4e85fdbf40a391daf32a8a91b"
SRC_URI[sha256sum] = "8b0341d39391abfec2b3f72dad2ec0ce8c37bd4443822322a64eacb36f0ce7b6"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "geometry"
