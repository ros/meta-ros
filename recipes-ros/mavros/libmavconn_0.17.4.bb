DESCRIPTION = "MAVLink communication library"
DEPENDS = "\
    mavlink \
    std-msgs \
    message-runtime \
    message-generation \
    geometry-msgs \
    rosconsole-bridge \
"

LICENSE = "BSD | GPLv3 | LGPLv3"

LIC_FILES_CHKSUM = "file://../LICENSE-BSD.txt;md5=093726b05f1e17a73a6fbef81e1e94d1 \
                    file://../LICENSE-GPLv3.txt;md5=d32239bcb673463ab874e80d47fae504 \
                    file://../LICENSE-LGPLv3.txt;md5=e6a600fd5e1d9cbde2d983680233ad02"

ROS_SPN = "libmavconn"

require mavros.inc

