DESCRIPTION = "A controller ensuring the safe operation of Kobuki."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roscpp nodelet pluginlib std-msgs geometry-msgs kobuki-msgs yocs-controllers ecl-threads"

require kobuki.inc
