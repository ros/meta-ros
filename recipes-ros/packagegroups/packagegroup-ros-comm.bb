DESCRIPTION = "ros-comm package group"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS_${PN} = "\
    rosconsole \
    rosparam \
    catkin \
    genmsg \
    rosgraph \
    genpy \
    rospack \
    roslib \
    rosunit \
    roscpp-serialization \
    roscpp-traits \
    rostest \
    message-generation \
    cpp-common \
    genlisp \
    rosgraph-msgs \
    xmlrpcpp \
    roswtf \
    std-msgs \
    rostime \
    gencpp \
    "
