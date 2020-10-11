# reintroduced from meta-oe as it was in:
# 44f4f89d7d sip: Upgrade to 4.19.19
# because it was later removed:
# 5057746583 meta-oe: Remove using python2
# c9e0f7dc69 sip: Delete python2 version
# and not yet reintroduced in meta-python2 (it might never be reintroduced there).
# It's needed by:
# meta-ros1-melodic/generated-recipes/orocos-kinematics-dynamics/python-orocos-kdl_1.4.0.bb

require sip.inc

DEPENDS = "python"

inherit python-dir pythonnative

PACKAGES += "python-sip"

FILES_python-sip = "${libdir}/${PYTHON_DIR}/site-packages/"
FILES_${PN}-dbg += "${libdir}/${PYTHON_DIR}/site-packages/.debug"

