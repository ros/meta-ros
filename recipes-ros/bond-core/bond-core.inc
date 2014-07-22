SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "babe5b8b8d6a29479f94a16ebe0bf19f"
SRC_URI[sha256sum] = "7c4e186177dd5a0b904777d56ba921be5df1a1539ef6380dd5ede437184eb99c"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "bond_core"
