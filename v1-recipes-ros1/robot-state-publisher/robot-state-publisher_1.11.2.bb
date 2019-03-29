DESCRIPTION = "This package allows you to publish the state of a robot to tf."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=18;endline=18;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "cmake-modules libeigen kdl-parser orocos-kdl rosconsole roscpp rostime sensor-msgs tf tf2-ros tf2-kdl"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f10d326400fd97f349a19a330c65aa3a"
SRC_URI[sha256sum] = "33b7606f0ea913e22887fe30521c94c1167f56197c03ce2985fc778876ea2141"

SRC_URI += "file://0001-Make-rostest-dependency-conditional-depending-on-CAT.patch"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
