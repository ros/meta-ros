inherit ${@bb.utils.contains('PACKAGECONFIG', 'python', 'python3targetconfig', '', d)}

PACKAGECONFIG ??= "python3"
PACKAGECONFIG[python3] = "--enable-python-bindings,,python3 swig-native"

RDEPENDS:${PN}-python = "python3-core"

inherit python3native distutils3-base

PACKAGES =+ "python3-${PN}"

FILES:python3-${PN} = "${PYTHON_SITEPACKAGES_DIR}"
