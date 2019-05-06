DESCRIPTION = "Publish master information - name, description, icon."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "${PYTHON_PN}-catkin-pkg"

require rocon-tools.inc

RDEPENDS_${PN} = "rospy rocon-console rocon-icons rocon-python-comms rocon-python-utils rocon-std-msgs"
