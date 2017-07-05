SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${ROS_SP}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "72417eb244903e824bd775ab74879982"
SRC_URI[sha256sum] = "b767ccd50aa8981884398c88a1b292e43e27410fdb5801684cef7bfa8e8cd667"

S = "${WORKDIR}/${ROS_SPN}-${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "velodyne"
