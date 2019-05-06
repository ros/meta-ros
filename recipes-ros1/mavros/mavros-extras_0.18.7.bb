DESCRIPTION = "Extra nodes and plugins for <a href="http://wiki.rot.org/mavros">MAVROS</a>"

LICENSE = "BSD | GPLv3 | LGPLv3"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=14;md5=5e724d80140fc99e7507c9876e320175"

MAVROS_RUN_AND_BUILD_DEPENDS = " \
     roscpp \
     tf2-ros \
     tf \
     geometry-msgs \
     mavros-msgs \
     sensor-msgs \
     std-msgs \
     visualization-msgs \
     urdf \
     image-transport \
     mavros \
 "

DEPENDS = "\
    cmake-modules \
    cv-bridge \
    ${MAVROS_RUN_AND_BUILD_DEPENDS} \
"

RDEPENDS_${PN} = "\
    ${MAVROS_RUN_AND_BUILD_DEPENDS} \ 
"

require mavros.inc

ROS_PKG_SUBDIR = "mavros_extras"
