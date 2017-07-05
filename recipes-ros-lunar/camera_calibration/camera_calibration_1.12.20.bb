# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "camera_calibration allows easy calibration of monocular or stereo
     cameras u"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=23;endline=23;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "catkin cv_bridge image_geometry message_filters rospy sensor_msgs std_srvs"
SRC_URI = "https://github.com/ros-gbp/image_pipeline-release/archive/release/lunar/camera_calibration/1.12.20-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "8a55303953606ee179c5224dcec6c663"
SRC_URI[sha256sum] = "18cb79c212e3b0b2eeedabf8f8ba0596d76af1e5127e18bea9f38753700fdb88"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
