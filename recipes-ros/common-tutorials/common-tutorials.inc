SRC_URI = "https://github.com/ros/common_tutorials/archive/${PV}.tar.gz;downloadfilename=${BP}.tar.gz"
SRC_URI[md5sum] = "0055265f3854afcf4cc0abff06a9f023"
SRC_URI[sha256sum] = "257f45f36463d5ffc04e1d60ac1fc6a2e7c1b11d012daa43b2eb43001383048c"

S = "${WORKDIR}/common_tutorials-${PV}/${ROS_BPN}"

inherit catkin
