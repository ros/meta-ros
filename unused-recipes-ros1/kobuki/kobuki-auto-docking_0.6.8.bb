DESCRIPTION = "Automatic docking for Kobuki"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roscpp rospy nodelet pluginlib message-filters actionlib \
  kdl-conversions std-msgs nav-msgs geometry-msgs actionlib-msgs kobuki-msgs \
  kobuki-dock-drive ecl-threads ecl-geometry ecl-linear-algebra"

require kobuki.inc
