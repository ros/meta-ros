SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1a8ae6b09936f75bf2bdb8300b46fb2f"
SRC_URI[sha256sum] = "12da6987a028b49dab269105519a4b23ce3a67cfeba475cd5b2b35ea8b23adf4"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "executive_smach"
