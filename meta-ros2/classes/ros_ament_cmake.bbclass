# The SOABI setting changed in newer python3 with:
# http://git.openembedded.org/openembedded-core/commit/?h=warrior&id=f3326309c7c22a6034917f6eee21908c61f44a2f
# https://github.com/python/cpython/pull/13196/commits/752b61141da76e81e53700bdbea81cd95af617b6


PYTHON_SOABI_ARCH = "${TUNE_ARCH}-${TARGET_OS}"
PYTHON_SOABI_ARCH_SUFFIX = "-gnu"
# The suffix is already included in TARGET_OS
PYTHON_SOABI_ARCH_SUFFIX_arm = ""
PYTHON_SOABI = "cpython-${@d.getVar('PYTHON_BASEVERSION').replace('.', '')}${PYTHON_ABI}-${PYTHON_SOABI_ARCH}${PYTHON_SOABI_ARCH_SUFFIX}"

EXTRA_OECMAKE_append = " -DBUILD_TESTING=OFF"
EXTRA_OECMAKE_append_class-target = " -DPYTHON_SOABI=${PYTHON_SOABI}"

# XXX Without STAGING_DIR_HOST path included, rmw-implementation:do_configure() fails with:
#
#    "Could not find ROS middleware implementation 'NOTFOUND'"
#
export AMENT_PREFIX_PATH="${STAGING_DIR_HOST}${prefix};${STAGING_DIR_NATIVE}${prefix}"

inherit cmake python3native

FILES_${PN}_prepend = " \
    ${datadir}/ament_index \
"
