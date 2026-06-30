PACKAGES += "${PYTHON_PN}-${PN}"

FILES:${PN} += "${datadir}/ament_index/resource_index/packages/osrf_pycommon"
FILES:${PYTHON_PN}-${PN} = "${PYTHON_SITEPACKAGES_DIR}/*"

BBCLASSEXTEND = "native nativesdk"
