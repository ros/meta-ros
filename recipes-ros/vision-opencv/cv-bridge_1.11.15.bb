DESCRIPTION = "CvBridge converts between ROS Image messages and OpenCV images"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost opencv rosconsole sensor-msgs ${PYTHON_PN}-numpy-native"

# This option disables python2 support because we can't support both python2
# and python3 since OE upstream has disabled python2 bindings in Boost.
EXTRA_OECMAKE =+ "${@'-DANDROID=ON' if d.getVar('PYTHON_PN', True) != 'python3' else ''}"

require vision-opencv.inc
