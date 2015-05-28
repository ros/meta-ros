DESCRIPTION = "ROS device driver for Velodyne HDL-64E, and HDL-32 LIDARs."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "diagnostic-updater libpcap nodelet pluginlib roscpp tf velodyne-msgs"

require velodyne.inc
