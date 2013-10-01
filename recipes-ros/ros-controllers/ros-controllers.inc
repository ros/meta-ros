SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "30810eb0c812ad5369684e57c81af2f6"
SRC_URI[sha256sum] = "f05bfad85bb2141632b2f4a13f6bc55e4ec3677cdb37039574935faa1058d239"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_controllers"
