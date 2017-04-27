DESCRIPTION = "Bound incoming velocity messages according to robot velocity and acceleration limits."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roscpp pluginlib nodelet geometry-msgs nav-msgs ecl-threads dynamic-reconfigure ${PYTHON_PN}-rospkg"

require yujin-ocs.inc
