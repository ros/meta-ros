SRC_URI = "git://github.com/orocos/orocos_kinematics_dynamics.git"
SRCREV = "d798f594552cb6f6223981b9c304d3db2b6a7d18"

S = "${WORKDIR}/git/${@d.getVar('BPN', True).replace('-', '_')}"

inherit cmake
