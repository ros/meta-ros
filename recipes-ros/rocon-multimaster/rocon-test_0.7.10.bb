DESCRIPTION = "Rocon test framework (i.e. multi-launch rostest framework)."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "rostest"

require rocon-multimaster.inc

RDEPENDS_${PN} = "rospy rostest rosunit rocon-console rocon-python-utils \
  roslaunch rocon-launch"
