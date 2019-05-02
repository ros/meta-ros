DESCRIPTION = "The rocon_app_utilities package"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "${PYTHON_PN}-catkin-pkg roslint"

require rocon-app-platform.inc

RDEPENDS_${PN} = "rocon-console rocon-python-utils rocon-uri ${PYTHON_PN}-rospkg roslaunch"
