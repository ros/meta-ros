DESCRIPTION = "Tests for validating the real-time capabilities of the ROS middleware"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=53d029b66e4cf837754fabf81702aad6"

DEPENDS = "roscpp"

SRC_URI = "git://github.com/bmwcarit/ros_realtime_tests.git"
SRCREV = "11e234b4147d23136dd4f27e7c229872d795c610"
PV = "0.0.1+git${SRCPV}"

S = "${WORKDIR}/git/timer_tests"

inherit catkin
