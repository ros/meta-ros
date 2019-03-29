SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "3ac4178c067133b13e5dbde46b0c857f"
SRC_URI[sha256sum] = "4497b6b9749fc39d57e569aa90082248bb5adb7b83c134308e49fedd20e76b74"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "joystick_drivers"

