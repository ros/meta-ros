SRC_URI = "https://github.com/tu-darmstadt-ros-pkg/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "5cede4ebdcae09d9bc7ad82b129500e0"
SRC_URI[sha256sum] = "80272696da825afbc21c5baa4477850f9df31174ae6bf65fe50519ff8eaf94bc"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "hector_slam"
