DESCRIPTION = "ROS nodelet for Kobuki: ROS wrapper for the Kobuki driver"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roscpp geometry-msgs sensor-msgs nav-msgs std-msgs tf angles diagnostic-updater diagnostic-msgs nodelet pluginlib \
  kobuki-msgs kobuki-driver kobuki-keyop kobuki-safety-controller ecl-exceptions ecl-sigslots ecl-streams ecl-threads"

require kobuki.inc
