
EXTRA_OECMAKE_append = " -DBUILD_TESTING=OFF -DPYTHON_SOABI=cpython-35m-${TUNE_ARCH}-${TARGET_OS}${ARMPKGSFX_EABI}"
# XXX Without STAGING_DIR_HOST path included, rmw-implementation:do_configure() fails with:
#
#    "Could not find ROS middleware implementation 'NOTFOUND'"
#
export AMENT_PREFIX_PATH="${STAGING_DIR_HOST}${prefix};${STAGING_DIR_NATIVE}${prefix}"

inherit cmake python3native

do_install_append() {
    rm -rf ${D}${datadir}/${ROS_BPN}/environment
    rm -f ${D}${datadir}/${ROS_BPN}/local_setup.bash
    rm -f ${D}${datadir}/${ROS_BPN}/local_setup.sh
    rm -f ${D}${datadir}/${ROS_BPN}/local_setup.zsh
    rm -f ${D}${prefix}/local_setup.bash
    rm -f ${D}${prefix}/local_setup.sh
    rm -f ${D}${prefix}/local_setup.zsh
    rm -f ${D}${prefix}/setup.bash
    rm -f ${D}${prefix}/setup.sh
    rm -f ${D}${prefix}/setup.zsh
    rm -f ${D}${prefix}/_order_packages.py
}

FILES_${PN} = " \
    ${datadir}/${ROS_BPN}/package.xml \
    ${datadir}/${ROS_BPN}/resource \
    ${datadir}/${ROS_BPN}/msg \
    ${datadir}/${ROS_BPN}/srv \
    ${datadir}/ament_index \
    ${libdir}/${PYTHON_DIR} \
    ${libdir}/${ROS_BPN} \
    ${libdir}/lib*.so \
"

FILES_${PN}-dev = " \
    ${datadir}/${ROS_BPN}/cmake \
    ${includedir} \
"
