SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f6dd416880d0e92985be5268699d9cb8"
SRC_URI[sha256sum] = "52d88c64047539f3d7552cee48def65f082e39d37221659b2533aecef429bb42"

SRC_URI += "file://0001-make-rostest-in-CMakeLists-optional-ros-rosdistro-30.patch;patchdir=.."

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "navigation"
