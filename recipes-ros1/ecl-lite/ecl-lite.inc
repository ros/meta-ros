SRC_URI = "https://github.com/stonier/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "0f2fe9ce82d783593a92e0677dcdcda6"
SRC_URI[sha256sum] = "b8a02aabecc9a47bde44c83c7e02669e7ce9a3e43f51315b89d10960ed83f3cc"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ecl_lite"
