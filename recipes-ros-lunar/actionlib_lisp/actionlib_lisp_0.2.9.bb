# Copyright 2017 Open Source Robotics Foundation
# Distributed under the terms of the BSD license

DESCRIPTION = "actionlib_lisp is a native implementation of the famous actionlib
   in Common L"
AUTHOR = "OSRF"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = file://package.xml;beginline=15;endline=15;md5=23f8de2430b349800266ded71351769e"

DEPENDS = "actionlib_msgs catkin cl_utils message_runtime roslisp"
SRC_URI = "https://github.com/ros-gbp/roslisp_common-release/archive/release/lunar/actionlib_lisp/0.2.9-0.tar.gz";downloadfilename=${ROS_SP}.tar.gz"

SRC_URI[md5sum] = "fcb02c9bf642d1bde36ac70a6267dfd8"
SRC_URI[sha256sum] = "4a35980cab90de0cafb113adee7c74712a0787cb64af6275179c26e8f9c95c60"
S = "${WORKDIR}/${ROS_SP}"

inherit catkin
