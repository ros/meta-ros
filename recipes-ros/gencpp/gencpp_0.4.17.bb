DESCRIPTION = "C++ ROS message and service generators."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "genmsg"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "ce9811cd733632b06716adf9e8ddd94b"
SRC_URI[sha256sum] = "364ec362655a79f8ec22580c736e8c21ff39c3f5f2597a6a088150ffd567650d"

inherit catkin
