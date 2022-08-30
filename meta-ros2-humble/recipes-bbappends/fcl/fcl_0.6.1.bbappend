# fcl needs to be compiled with octomap or moveit-core will fail because
# OcTreed is not definded then
DEPENDS:append = " \
    octomap \
"
