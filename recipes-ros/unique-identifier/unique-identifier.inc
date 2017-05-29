SRC_URI = "https://github.com/ros-geographic-info/${ROS_SPN}/archive/${ROS_SPN}-${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "163a56d0b5b98f42f93fe48b8482e25f"
SRC_URI[sha256sum] = "e376df28058d69da4c3c5fce4ef5d3cc24518ed9b64a181055ff86a2fc11b832"

S = "${WORKDIR}/${ROS_SPN}-${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "unique_identifier"
