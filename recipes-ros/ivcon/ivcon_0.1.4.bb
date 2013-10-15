DESCRIPTION = "Mesh Conversion Utility used to generate '.iv' files from '.stl' files."
SECTION = "devel"
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://package.xml;beginline=18;endline=18;md5=162b49cfbae9eadf37c9b89b2d2ac6be"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "eb0600372f526407d010eca4384de309"
SRC_URI[sha256sum] = "78c1ad40708a359c4d4648fbcba538379ad07fc49d7aa7ca676591e2d5c66344"

inherit catkin
