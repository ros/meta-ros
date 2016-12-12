DESCRIPTION = "MAVROS -- MAVLink extendable communication node for ROS"
DEPENDS = "\
    angles \
    catkin \
    cmake-modules \
    diagnostic-msgs \
    diagnostic-updater \
    eigen-conversions \
    geometry-msgs \
    libmavconn \
    mavlink \
    mavros-msgs \
    message-runtime \
    message-generation \
    nav-msgs \
    pluginlib \
    rosconsole-bridge \
    roscpp \
    rospy \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2-ros \
"

RDEPENDS_${PN} = "\
    mavlink \
    libmavconn \
    mavlink \
    mavros-msgs \
"


LICENSE = "BSD | GPLv3 | LGPLv3"

LIC_FILES_CHKSUM = "file://../LICENSE-BSD.txt;md5=093726b05f1e17a73a6fbef81e1e94d1 \
                    file://../LICENSE-GPLv3.txt;md5=d32239bcb673463ab874e80d47fae504 \
                    file://../LICENSE-LGPLv3.txt;md5=e6a600fd5e1d9cbde2d983680233ad02"

ROS_SPN = "mavros"

require mavros.inc

