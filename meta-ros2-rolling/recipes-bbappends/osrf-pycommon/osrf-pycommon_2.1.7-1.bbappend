PACKAGES =+ "${PYTHON_PN}-${BPN}"

FILES:${PN} += "${datadir}/ament_index/resource_index/packages/osrf_pycommon"
FILES:${PYTHON_PN}-${BPN} = "${PYTHON_SITEPACKAGES_DIR}/*"

BBCLASSEXTEND = "native nativesdk"
