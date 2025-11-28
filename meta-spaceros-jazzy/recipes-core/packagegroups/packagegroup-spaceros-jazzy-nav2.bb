# Copyright (c) 2025 Wind River Systems, Inc.

DESCRIPTION = "All packages from Space ROS"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_jazzy

PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    angles\
    behaviortree-cpp\
    bond\
    bondcpp\
    costmap-queue\
    cv-bridge\
    diagnostic-updater\
    dwb-core\
    dwb-critics\
    dwb-msgs\
    dwb-plugins\
    geographic-msgs\
    image-transport\
    laser-geometry\
    map-msgs\
    nav2-amcl\
    nav2-behaviors\
    nav2-behavior-tree\
    nav2-bt-navigator\
    nav2-collision-monitor\
    nav2-common\
    nav2-controller\
    nav2-core\
    nav2-costmap-2d\
    nav-2d-msgs\
    nav-2d-utils\
    nav2-dwb-controller\
    nav2-graceful-controller\
    nav2-lifecycle-manager\
    nav2-map-server\
    nav2-mppi-controller\
    nav2-msgs\
    nav2-navfn-planner\
    nav2-planner\
    nav2-regulated-pure-pursuit-controller\
    nav2-rotation-shim-controller\
    nav2-simple-commander\
    nav2-smac-planner\
    nav2-smoother\
    nav2-theta-star-planner\
    nav2-util\
    nav2-velocity-smoother\
    nav2-voxel-grid\
    nav2-waypoint-follower\
    navigation2\
    ompl\
    opennav-docking\
    opennav-docking-bt\
    opennav-docking-core\
    robot-localization\
    smclib\
    yaml-cpp-vendor\
"
#    nav2-constrained-smoother
