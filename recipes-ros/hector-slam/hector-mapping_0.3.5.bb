DESCRIPTION = "hector_mapping is a SLAM approach that can be used  \
without odometry as well as on platforms that exhibit roll/pitch motion \
(of the sensor, the platform or both)."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=19;endline=19;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "cmake-modules message-runtime boost nav-msgs visualization-msgs tf message-filters laser-geometry tf-conversions"

require hector-slam.inc
