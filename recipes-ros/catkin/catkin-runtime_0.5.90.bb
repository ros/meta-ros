ROS_SPN = "catkin"

require catkin.inc

S = "${WORKDIR}/catkin-${PV}"

# This package includes ONLY the python packages.
# The catkin_${PV} package includes all other files
# from the catkin tool.
FILES_${PN} = "${PYTHON_SITEPACKAGES_DIR}"

RDEPENDS_${PN} = "\
    python-catkin-pkg python-argparse python-misc python-multiprocessing \
    python-shell python-subprocess python-xml python-pkgutil"

# Delete everything but the python packages in order to avoid
# that the QA error [installed-vs-shipped] hits on us.
do_install_append() {
    rm -rf ${D}${ros_bindir}
    rm -rf ${D}${ros_datadir}
    rm -rf ${D}${ros_libdir}/pkgconfig
}
