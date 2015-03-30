DESCRIPTION = "Provides a ROS driver for the Sparkfun Razor IMU 9DOF. \
It also provides Arduino firmware that runs on the Razor board, and which must be \
installed on the Razor board for the system to work. \
A node which displays the attitude (roll, pitch and yaw) of the Razor board \
(or any IMU) is provided for testing."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "dynamic-reconfigure"

SRC_URI = "https://github.com/KristofRobot/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "8b82e5752d5d4f788e87b434ffee6a39"
SRC_URI[sha256sum] = "97dac4e4d287b41d40aa9c1a4bb09f716e244a49f928cfc1ec31a9d2962965f9"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RDEPENDS_${PN} = "rospy tf sensor-msgs python-pyserial"
