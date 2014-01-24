DESCRIPTION = "IMU Pipeline includes tools for processing and pre-processing IMU messages for easier use by later subscribers."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roscpp sensor-msgs geometry-msgs nav-msgs tf"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "aebca1dfdce3cb8034cd4d203485e40e"
SRC_URI[sha256sum] = "bb49464de2f2b9c63c31e2bf61804c24a69ee448c1d76e3ff978b4bef9c7cd87"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
