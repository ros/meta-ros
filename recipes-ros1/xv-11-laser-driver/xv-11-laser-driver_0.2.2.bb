DESCRIPTION = "Neato XV-11 Laser Driver. This driver works with the laser when it is removed \
from the XV-11 Robot as opposed to reading scans from the Neato's USB port."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "sensor-msgs roscpp boost"

SRC_URI = "https://github.com/rohbotics/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "2f60eab48f5b1d2a587b21887629fd0a"
SRC_URI[sha256sum] = "ca62f2eac7f716bb1547914d2dee8d63459de34c12cea972f770a897dd704307"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
