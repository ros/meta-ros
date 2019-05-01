SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "13ce3d3c86dbe7f8e7b9eed26c8a7418"
SRC_URI[sha256sum] = "e5138f55e537a88c2c53b12a8bb4cb5b3bfcd247b1c49d8b40d01ce32c33d5b7"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "imu_pipeline"
