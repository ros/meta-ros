DESCRIPTION = "ros1-comm package group"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_${ROS_DISTRO}

PACKAGES = "${PN}"

RDEPENDS_${PN} = "\
    rosconsole \
    rosparam \
    catkin \
    genmsg \
    rosgraph \
    genpy \
    rosbuild \
    rospack \
    rosmake \
    rosboost-cfg \
    rosbash \
    roslib \
    roscreate \
    mk \
    rosclean \
    rosunit \
    roslang \
    roscpp \
    rosout \
    roscpp-serialization \
    roscpp-traits \
    topic-tools \
    rostest \
    rostopic \
    message-generation \
    cpp-common \
    message-filters \
    rosservice \
    rospy \
    rosgraph-msgs \
    rosnode \
    std-srvs \
    xmlrpcpp \
    roslaunch \
    rosmaster \
    roswtf \
    rosbag-storage \
    rosbag \
    rosmsg \
    std-msgs \
    message-runtime \
    rostime \
    gencpp \
    roslz4 \
"
