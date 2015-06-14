DESCRIPTION = "Mesh Conversion Utility used to generate '.iv' files from '.stl' files."
SECTION = "devel"
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://package.xml;beginline=18;endline=18;md5=162b49cfbae9eadf37c9b89b2d2ac6be"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "632f9a1faaf05ba1e92e133156af9434"
SRC_URI[sha256sum] = "cc79cfe48a7630c32c0e0d4418e87e868c6ac377fab959c23f966a00e3b01120"

inherit catkin
