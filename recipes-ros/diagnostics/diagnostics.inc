SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "34bb53fbcf57924cc2c15e185451869b"
SRC_URI[sha256sum] = "9f2c6012f60e55e7735ba2d08dbc9bcd96f09ca9d3df223a0f1966bdab454dea"

SRC_URI += "file://0001-make-rostest-in-CMakeLists-optional-ros-rosdistro-30.patch;patchdir=.."

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "diagnostics"
