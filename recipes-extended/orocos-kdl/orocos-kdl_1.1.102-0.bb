DESCRIPTION = "Kinematics and Dynamics Library: Orocos project to supply RealTime usable kinematics and dynamics code, it contains code for rigid body kinematics calculations and representations for kinematic structures and their inverse and forward kinematic solvers."
SECTION = "devel"
LICENSE = "LGPL"
LIC_FILES_CHKSUM = "file://manifest.xml;beginline=9;endline=9;md5=17b5e0bdb72a7c324b6ddcfaa9829e8f"


SRC_URI = "https://github.com/smits/orocos-kdl-release/archive/release/hydro/orocos_kdl/${PV}.tar.gz;downloadfilename=${BP}.tar.gz"
SRC_URI[md5sum] = "ead8714d324df55c8e0b74a6b0b9acf7"
SRC_URI[sha256sum] = "dd57564d5273fba15fd7925b08459f03ebb0ce0d65e18e72877ce2d7810bf0d7"

S = "${WORKDIR}/orocos-kdl-release-release-hydro-orocos_kdl-${PV}"

inherit cmake
