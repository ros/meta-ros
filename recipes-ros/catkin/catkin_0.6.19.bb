require catkin.inc

SRC_URI += "file://environment.d-catkin.sh"

DEPENDS_class-native += "catkin-runtime"

# The files in ${PYTHON_SITEPACKAGES_DIR} and catkin_find are
# installed by the catkin-runtime package. Therefore, we remove
# them here so that they are not installed.
# Moreover: the ${ros_libdir}/python2.7 is empty. We need to
# remove it, otherwise the QA error [installed-vs-shipped] will hit on us.
FILES_${PN} = "\
    ${ros_bindir}/catkin_*_* \
    ${ros_bindir}/catkin_make \
    ${ros_libdir}/pkgconfig \
    ${ros_datadir} \
    ${ros_sysconfdir} \
    ${ros_stackdir} \
    "
FILES_${PN}-dev = ""

RDEPENDS_${PN}_class-native = "${PYTHON_PN}-catkin-pkg"
RDEPENDS_${PN} = "cmake make binutils binutils-symlinks gcc gcc-symlinks g++ g++-symlinks \
    catkin-runtime  ${PYTHON_PN}-empy"

do_install_append() {
    rm ${D}${ros_bindir}/catkin_find
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}
    rmdir ${D}${ros_libdir}/${PYTHON_DIR}
}

# Append environment hook for SDK
do_install_append_class-nativesdk() {
    mkdir -p ${D}${SDKPATHNATIVE}/environment-setup.d
    install -m 644 ${WORKDIR}/environment.d-catkin.sh ${D}${SDKPATHNATIVE}/environment-setup.d/catkin.sh
}

FILES_${PN}_append_class-nativesdk = " ${SDKPATHNATIVE}"

BBCLASSEXTEND += "native nativesdk"
