SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a91a68a28f8e0d7eb98ed348ff6b385b"
SRC_URI[sha256sum] = "8dd843a371800868d0c9fd2fe3eeb019b173e1950357167f54b8edd8042d9f65"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin ros-insane

ROS_SPN = "moveit"
