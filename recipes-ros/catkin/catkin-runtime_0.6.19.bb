ROS_SPN = "catkin"

require catkin.inc

SRC_URI += "\
    file://0001-ignore-LD_LIBRARY_PATH-set-in-environment_cache.py.patch \
    "

S = "${WORKDIR}/catkin-${PV}"

# This package includes ONLY the python packages AND catkin_find
# The catkin_${PV} package includes all other files
# from the catkin tool.
FILES_${PN} = "${PYTHON_SITEPACKAGES_DIR} ${ros_bindir}/catkin_find"

RDEPENDS_${PN}_class-native = ""
RDEPENDS_${PN} = "\
    ${PYTHON_PN}-catkin-pkg ${PYTHON_PN}-misc ${PYTHON_PN}-multiprocessing \
    ${PYTHON_PN}-shell ${PYTHON_PN}-xml ${PYTHON_PN}-pkgutil \
    ${@'python-argparse python-subprocess' if d.getVar('PYTHON_PN', True) == 'python2' else ''}"

# Delete everything but the python packages in order to avoid
# that the QA error [installed-vs-shipped] hits on us.
do_install_append() {
    rm  ${D}${ros_bindir}/catkin_*_*
    rm  ${D}${ros_bindir}/catkin_make
    rm -rf ${D}${ros_datadir}
    rm -rf ${D}${ros_libdir}/pkgconfig
}

BBCLASSEXTEND += "native"
