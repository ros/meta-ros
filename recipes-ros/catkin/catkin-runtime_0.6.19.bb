ROS_SPN = "catkin"

require catkin.inc

SRC_URI += "\
    file://0001-ignore-LD_LIBRARY_PATH-set-in-environment_cache.py.patch \
    "

S = "${WORKDIR}/catkin-${PV}"

# This package includes ONLY the python packages AND catkin_find
# The catkin_${PV} package includes all other files
# from the catkin tool.
FILES_${PN} = "${PYTHON_SITEPACKAGES_DIR} ${ros_bindir}/catkin_find ${ros_prefix}/.catkin"
FILES_${PN}-dev = ""

RDEPENDS_${PN}_class-native = ""
RDEPENDS_${PN} = "\
    ${PYTHON_PN}-catkin-pkg ${PYTHON_PN}-argparse ${PYTHON_PN}-misc ${PYTHON_PN}-multiprocessing \
    ${PYTHON_PN}-shell ${PYTHON_PN}-subprocess ${PYTHON_PN}-xml ${PYTHON_PN}-pkgutil"

# Delete everything but the python packages in order to avoid
# that the QA error [installed-vs-shipped] hits on us.
do_install_append() {
    rm  ${D}${ros_bindir}/catkin_*_*
    rm  ${D}${ros_bindir}/catkin_make
    rm -rf ${D}${ros_datadir}
    rm -rf ${D}${ros_libdir}/pkgconfig

    # Manually add the marker file
    touch ${D}${ros_prefix}/.catkin
}

# Append environment hook for SDK
do_install_append_class-nativesdk() {
    mkdir -p ${D}${SDKPATHNATIVE}/environment-setup.d

    script=${D}${SDKPATHNATIVE}/environment-setup.d/catkin-runtime.sh

    # Note: These exports need to be kept in sync with the ros_* exports as well as
    #       PYTHON_SITEPACKAGES_DIR in ros.bbclass; however, the variables can not
    #       be used directly here due to the prefix base_prefix.
    echo "export ROSDISTRO=${ROSDISTRO}" >> $script
    echo "export PATH=\$PATH:\$OECORE_NATIVE_SYSROOT/opt/ros/\$ROSDISTRO/bin" >> $script
    echo "export PYTHONPATH=\$OECORE_NATIVE_SYSROOT/opt/ros/\$ROSDISTRO/${baselib}/${PYTHON_DIR}/site-packages" >> $script
    echo "export ROS_ROOT=\$OECORE_TARGET_SYSROOT/opt/ros/\$ROSDISTRO/share/ros" >> $script
    echo "export CMAKE_PREFIX_PATH=\$OECORE_TARGET_SYSROOT/opt/ros/\$ROSDISTRO:\$OECORE_NATIVE_SYSROOT/opt/ros/\$ROSDISTRO" >> $script
}

FILES_${PN}_append_class-nativesdk = " ${SDKPATHNATIVE}"

catkin_sysroot_preprocess_append() {
    install -m 644 -t ${SYSROOT_DESTDIR}${ros_prefix} ${D}${ros_prefix}/.catkin
}

BBCLASSEXTEND += "native nativesdk"
