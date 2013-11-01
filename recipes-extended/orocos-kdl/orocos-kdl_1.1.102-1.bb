DESCRIPTION = "Kinematics and Dynamics Library: Orocos project to supply RealTime usable kinematics and dynamics code, it contains code for rigid body kinematics calculations and representations for kinematic structures and their inverse and forward kinematic solvers."
SECTION = "devel"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=a8ffd58e6eb29a955738b8fcc9e9e8f2"

SRC_URI = "git://github.com/orocos/orocos_kinematics_dynamics.git"
SRCREV = "15fb082c10b58078841c14c067ac55f592733447"
PV = "1.1.102+git${SRCREV}"

S = "${WORKDIR}/git/orocos_kdl"

inherit cmake

FILES_${PN}-dev += "/usr/share/orocos_kdl/package.xml /usr/share/orocos_kdl/orocos_kdl-config.cmake"

do_install_append() {
        # remove sysroot library path from pkgconfig files
        sed -i -e 's#${STAGING_INCDIR}#${includedir}#g' \
                   ${D}${libdir}/pkgconfig/*.pc
}
