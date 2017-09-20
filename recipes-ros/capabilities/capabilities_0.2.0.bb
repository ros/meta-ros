DESCRIPTION = "Package which implements capabilities"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=62135a7570582b9018c89013d4815380"

DEPENDS = "message-generation roslaunch rospy std-msgs std-srvs"

SRC_URI = "git://github.com/osrf/${PN}.git;branch=master;protocol=git"
SRCREV = "c6c71a9ac17e310787242f5b75bd1e4d86349844"

S = "${WORKDIR}/git"

inherit catkin

RDEPENDS_${PN} = "bondpy message-runtime nodelet python-pyyaml roslaunch"
