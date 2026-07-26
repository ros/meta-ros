LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://../orocos_kdl/COPYING;md5=a8ffd58e6eb29a955738b8fcc9e9e8f2 \
                    file://../orocos_kdl/debian/copyright;md5=57b48fd56cf39965622e7d8a9ff2ed50"

SRC_URI = "\
    git://github.com/orocos/orocos_kinematics_dynamics.git;protocol=https;branch=master \
    file://pytest.ini \
"

SRCREV = "f9f90c39b86fd027ade83a0bac2c07aea2170c46"

S = "${UNPACKDIR}/${BPN}-${PV}/python_orocos_kdl"

DEPENDS = "\
    orocos-kdl \
    python3-pybind11-native \
"

EXTRA_OECMAKE:append = " \
    -DPYTHON_SITE_PACKAGES_INSTALL_DIR=${PYTHON_SITEPACKAGES_DIR} \
"

inherit cmake python3-dir python3native ptest-python-pytest

FILES:${PN}:append = " \
    ${PYTHON_SITEPACKAGES_DIR}/PyKDL.*.so \
"

# QA Issue: File '/usr/lib/python3.13/site-packages/PyKDL.so' from python3-pykdl was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP:${PN} += "already-stripped"

RDEPENDS:${PN}-ptest += " \
    python3-pytest \
    python3-unittest-automake-output \
"

do_install_ptest:append() {
    install -d ${D}${PTEST_PATH}
    install -m 0644 ${UNPACKDIR}/pytest.ini ${D}${PTEST_PATH}/
}
