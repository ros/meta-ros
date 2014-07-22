DESCRIPTION = "Tests for validating the real-time capabilities of the ROS publish subscribe communication mechanism"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${WORKDIR}/${ROS_SP}/LICENSE.bsd;md5=53d029b66e4cf837754fabf81702aad6"

DEPENDS = "roscpp message-generation message-runtime std-msgs rt-tests-support"

require ros-realtime-tests.inc
