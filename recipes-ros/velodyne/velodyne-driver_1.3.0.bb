DESCRIPTION = "ROS device driver for Velodyne HDL-64E, and HDL-32 LIDARs."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "diagnostic-updater dynamic-reconfigure ${PYTHON_PN}-rospkg libpcap nodelet pluginlib roscpp tf velodyne-msgs"

require velodyne.inc

RDEPENDS_${PN} = "bash"
