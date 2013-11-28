SRC_URI = "git://github.com/orocos/orocos_kinematics_dynamics.git"
SRCREV = "15fb082c10b58078841c14c067ac55f592733447"
PV = "1.1.102+git${SRCREV}"

S = "${WORKDIR}/git/${@d.getVar('BPN', True).replace('-', '_')}"

inherit cmake

ROS_SPN = "kdl"
