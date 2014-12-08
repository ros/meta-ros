DESCRIPTION = "Package containing PCL (Point Cloud Library)-related ROS messages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "sensor-msgs"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "fe15804bfed5d4c667a0c869145d01f9"
SRC_URI[sha256sum] = "d02be421db01d22f8555f616b3658682ee60a885cc3dc37668fbc28454f562f8"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
