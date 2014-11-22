DESCRIPTION = "Provides a ROS driver for the Sparkfun Razor IMU 9DOF. \
It also provides Arduino firmware that runs on the Razor board, and which must be \
installed on the Razor board for the system to work. \
A node which displays the attitude (roll, pitch and yaw) of the Razor board \
(or any IMU) is provided for testing."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/KristofRobot/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "3a05ce324d043400a2a214bcc040f843"
SRC_URI[sha256sum] = "4a948cc34e36ce5be9c3e4a2e681eed713e1a5a3df674dd4761a0795e607da35"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RDEPENDS_${PN} = "rospy tf sensor-msgs python-pyserial"
