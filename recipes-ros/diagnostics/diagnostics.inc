SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "34bb53fbcf57924cc2c15e185451869b"
SRC_URI[sha256sum] = "9f2c6012f60e55e7735ba2d08dbc9bcd96f09ca9d3df223a0f1966bdab454dea"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "diagnostics"
