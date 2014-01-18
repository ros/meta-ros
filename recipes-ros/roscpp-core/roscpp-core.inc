SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "36dcddf46de3425b25f7e09551607e9f"
SRC_URI[sha256sum] = "afd43664b01e935108b7aa539d3a8d19e85fff0860a4fc7e38ee965e49ae9d15"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "roscpp_core"
