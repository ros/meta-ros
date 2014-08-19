DESCRIPTION = "Point cloud conversions for Velodyne 3D LIDARs."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "angles nodelet pcl-conversions pcl-ros pluginlib roscpp roslib sensor-msgs tf \
    velodyne-driver velodyne-msgs yaml-cpp"

require velodyne.inc
