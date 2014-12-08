SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "095c1dd8ed0fbd5775ba6986f4e4a074"
SRC_URI[sha256sum] = "91e0d491bd08dce8629876bf6005a1aaabcb130413ed749c4ab168e17f0118fa"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "imu_pipeline"
