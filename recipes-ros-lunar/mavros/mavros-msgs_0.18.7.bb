DESCRIPTION = "mavros_msgs defines messages for MAVROS"
LICENSE = "BSD | GPLv3 | LGPLv3"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=13;md5=9b511d4c606b1a23e454d3260818d003"

DEPENDS = " \
    message-generation \
    std-msgs \
    geometry-msgs \
"

RDEPENDS_${PN} = " \
    message-runtime \
    std-msgs \
    geometry-msgs \
"

require mavros.inc

ROS_PKG_SUBDIR = "mavros_msgs"
