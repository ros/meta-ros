SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "7832ec9a9e467e60747a886361624fb7"
SRC_URI[sha256sum] = "cdcad6a9a311bbe2f8f05ece55f595c0443b3a99e1c9ebd7b1c50ff05d6de123"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "bond_core"
