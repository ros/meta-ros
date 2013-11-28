DESCRIPTION = "Kinematics and Dynamics Library: Orocos project to supply RealTime usable kinematics and dynamics code, it contains code for rigid body kinematics calculations and representations for kinematic structures and their inverse and forward kinematic solvers."
SECTION = "devel"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=a8ffd58e6eb29a955738b8fcc9e9e8f2"

DEPENDS = "libeigen"

require kdl.inc

do_install_append() {
        # remove sysroot library path from pkgconfig files
        sed -i -e 's#${STAGING_INCDIR}#${includedir}#g' \
                   ${D}${libdir}/pkgconfig/*.pc
}

FILES_${PN}-dev += "${datadir}/orocos_kdl/*"
