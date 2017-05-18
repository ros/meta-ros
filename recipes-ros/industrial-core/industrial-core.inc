SRC_URI = "https://github.com/ros-industrial/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "7a1955ab2b909b79ad40d11516a2743c"
SRC_URI[sha256sum] = "6c21cf1383e90cefcbb536675fa0503b67d0f7cc5777f76f6dc49fd14d4254e9"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "industrial_core"
