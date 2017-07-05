DESCRIPTION = "Node/nodelet combination to transform sensor_msgs::Imu data \
  from one frame into another."
SECTION = "devel"
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=162b49cfbae9eadf37c9b89b2d2ac6be"

DEPENDS = "geometry-msgs nodelet message-filters roscpp roslaunch sensor-msgs \
  tf2 tf2-ros tf2-sensor-msgs topic-tools"

require imu-pipeline.inc
