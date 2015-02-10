SRC_URI = "https://github.com/tu-darmstadt-ros-pkg/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "df4314263e9ce67968fdcf09bb9fb8f2"
SRC_URI[sha256sum] = "e3da461e7e4020218ae3d26f2eb6e135d1ac486bb0dab52f60e9d2349c637e5c"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "hector_slam"
