DESCRIPTION = "The smach_ros package contains extensions for the SMACH library to integrate it tightly with ROS."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "rostest rospy rostopic std-msgs std-srvs actionlib actionlib-msgs"

RDEPENDS_${PN} = "smach smach-msgs"

require executive-smach.inc
