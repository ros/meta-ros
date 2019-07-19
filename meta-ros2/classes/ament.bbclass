PYTHON_SOABI_ARCH_x86 = "i386-${TARGET_OS}-gnu"
PYTHON_SOABI_ARCH_x86-64 = "x86_64-${TARGET_OS}-gnu"
PYTHON_SOABI_ARCH_arm = "${TUNE_ARCH}-${TARGET_OS}${ARMPKGSFX_EABI}"
PYTHON_SOABI_ARCH_aarch64 = "${TUNE_ARCH}-${TARGET_OS}${ARMPKGSFX_EABI}-gnu"

EXTRA_OECMAKE_append = " -DBUILD_TESTING=OFF -DPYTHON_SOABI=cpython-${@d.getVar('PYTHON_BASEVERSION').replace('.', '')}${PYTHON_ABI}-${PYTHON_SOABI_ARCH}"

# XXX Without STAGING_DIR_HOST path included, rmw-implementation:do_configure() fails with:
#
#    "Could not find ROS middleware implementation 'NOTFOUND'"
#
export AMENT_PREFIX_PATH="${STAGING_DIR_HOST}${prefix};${STAGING_DIR_NATIVE}${prefix}"

inherit cmake python3native

FILES_${PN}_prepend = " \
    ${datadir}/ament_index \
"
