DESCRIPTION = "Xacro is an XML macro language."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roslint"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "0ab54d837509adc0579eacae4f27d8b6"
SRC_URI[sha256sum] = "bcb0c5706a7da913431d49478b795667b32c7f7dee28639024b267e022ffc25a"

inherit catkin
