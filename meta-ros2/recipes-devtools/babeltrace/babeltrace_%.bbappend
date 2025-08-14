inherit ${@bb.utils.contains('PACKAGECONFIG', 'python', 'python3targetconfig', '', d)}

PACKAGECONFIG ??= "python3"
PACKAGECONFIG[python3] = "--enable-python-bindings,,python3 swig-native"

DEPENDS += "python3-setuptools-native"

RDEPENDS:${PN}-python = "python3-core"

inherit python3native

PACKAGES =+ "python3-${PN}"

FILES:python3-${PN} = "${PYTHON_SITEPACKAGES_DIR}"

export PYTHON_CONFIG="${STAGING_EXECPREFIXDIR}/python-target-config/python3-config"
