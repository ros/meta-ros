DESCRIPTION = "tf is a package that lets the user keep track of multiple coordinate frames over time."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=18;endline=18;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "angles geometry-msgs message-filters sensor-msgs tf2-ros"

require geometry.inc

SRC_URI += "file://0001-Fix-stdlib.h-No-such-file-or-directory-errors-in-GCC.patch;striplevel=2"

RDEPENDS_${PN} = "${PYTHON_PN}-numpy"

# This option disables python support in case of python3 flavour of ROS because
# only python2 is supported by tf.
EXTRA_OECMAKE =+ "${@'-DANDROID=ON' if d.getVar('PYTHON_PN', True) == 'python3' else ''}"
