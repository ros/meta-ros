FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

require catkin.inc

SRC_URI += "file://environment.d-catkin.sh file://0001-cross-compilation.patch"

DEPENDS = "cmake make python-empy python-catkin-pkg"

# The "catkin-runtime" package includes ONLY the python packages AND catkin_find
# The "catkin" package includes all other files from the catkin tool.
FILES_${PN} = "\
    ${ros_bindir}/catkin_*_* \
    ${ros_bindir}/catkin_make \
    ${ros_libdir}/pkgconfig \
    ${ros_sysconfdir} \
    ${ros_stacksdir} \
    ${ros_datadir} \
    "

FILES_${PN}-dev = "\
    ${datadir}/${ROS_BPN}/cmake \
    ${datadir}/${ROS_BPN}/*.template \
    "

RDEPENDS_${PN} += "\
    catkin-runtime \
    cmake \
    make \
    binutils \
    binutils-symlinks \
    gcc \
    gcc-symlinks \
    g++ \
    g++-symlinks \
    gettext \
    libstdc++ \
    libtool \
    pkgconfig \
    python-empy \
    catkin-runtime \
    "

RDEPENDS_${PN}_class-native = "\
    catkin-runtime-native \
    "

RDEPENDS_${PN}_class-nativesdk += "\
    nativesdk-catkin-runtime \
    nativesdk-cmake \
    nativesdk-make \
    nativesdk-python-empy \
    nativesdk-catkin-runtime \
    "

# The files in ${PYTHON_SITEPACKAGES_DIR} and catkin_find are
# installed by the catkin-runtime package. Therefore, we remove
# them here so that they are not installed.
# Moreover: the ${ros_libdir}/python2.7 is empty. We need to
# remove it, otherwise the QA error [installed-vs-shipped] will hit on us.
do_install_append() {
    rm ${D}${ros_bindir}/catkin_find
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}
    rmdir ${D}${ros_libdir}/python2.7
}

# Append environment hook for SDK
do_install_append_class-nativesdk() {
    mkdir -p ${D}${SDKPATHNATIVE}/environment-setup.d
    install -m 644 ${WORKDIR}/environment.d-catkin.sh ${D}${SDKPATHNATIVE}/environment-setup.d/catkin.sh
}

FILES_${PN}_append_class-nativesdk = " ${SDKPATHNATIVE}"

BBCLASSEXTEND += "native nativesdk"
