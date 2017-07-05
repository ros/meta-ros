DESCRIPTION = "Single image rectification and color processing."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost camera-calibration-parsers cv-bridge dynamic-reconfigure \
  image-geometry image-transport nodelet nodelet-topic-tools opencv roscpp \
  sensor-msgs ${PYTHON_PN}-rospkg"

require image-pipeline.inc
