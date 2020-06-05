# Imported from meta-iot-cloud as in:
# https://github.com/intel-iot-devkit/meta-iot-cloud/blob/fa0c6d50a517309dd6164bde3a67aa2bd789b046/recipes-devtools/python/python3-argcomplete_1.9.4.bb
inherit pypi setuptools3 update-alternatives
require python-argcomplete.inc

ALTERNATIVE_${PN} = "\
    activate-global-python-argcomplete \
    python-argcomplete-check-easy-install-script \
    register-python-argcomplete \
"

ALTERNATIVE_LINK_NAME[activate-global-python-argcomplete] = "${bindir}/activate-global-python-argcomplete"
ALTERNATIVE_LINK_NAME[python-argcomplete-check-easy-install-script] = "${bindir}/python-argcomplete-check-easy-install-script"
ALTERNATIVE_LINK_NAME[register-python-argcomplete] = "${bindir}/register-python-argcomplete"

ALTERNATIVE_PRIORITY = "30"
