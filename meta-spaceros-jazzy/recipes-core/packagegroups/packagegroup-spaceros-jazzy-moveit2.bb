# Copyright (c) 2025 Wind River Systems, Inc.

DESCRIPTION = "MoveIt2 packages from Space ROS"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_jazzy

PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    ackermann-msgs\
    ackermann-steering-controller\
    admittance-controller\
    ament-cmake-catch2\
    angles\
    backward-ros\
    bicycle-steering-controller\
    camera-calibration-parsers\
    camera-info-manager\
    chained-filter-controller\
    controller-interface\
    controller-manager\
    controller-manager-msgs\
    control-msgs\
    control-toolbox\
    cv-bridge\
    diagnostic-updater\
    diff-drive-controller\
    effort-controllers\
    eigen-stl-containers\
    example-interfaces\
    filters\
    force-torque-sensor-broadcaster\
    forward-command-controller\
    generate-parameter-library\
    generate-parameter-library-py\
    geometric-shapes\
    gpio-controllers\
    gps-sensor-broadcaster\
    graph-msgs\
    gripper-controllers\
    hardware-interface\
    hardware-interface-testing\
    image-common\
    image-geometry\
    image-transport\
    imu-sensor-broadcaster\
    interactive-markers\
    joint-limits\
    joint-state-broadcaster\
    joint-state-publisher\
    joint-trajectory-controller\
    joy\
    kinematics-interface\
    kinematics-interface-kdl\
    laser-geometry\
    launch-param-builder\
    libcurl-vendor\
    map-msgs\
    mecanum-drive-controller\
    moveit-msgs\
    moveit-resources\
    object-recognition-msgs\
    octomap\
    octomap-msgs\
    omni-wheel-drive-controller\
    ompl\
    osqp-vendor\
    pal-statistics\
    pal-statistics-msgs\
    parallel-gripper-controller\
    parameter-traits\
    pid-controller\
    point-cloud-transport\
    pose-broadcaster\
    position-controllers\
    random-numbers\
    range-sensor-broadcaster\
    realtime-tools\
    resource-retriever\
    rmf-utils\
    ros2cli-common-extensions\
    ros2-control\
    ros2controlcli\
    ros2-control-cmake\
    ros2-controllers\
    ros2-control-test-assets\
    ros-industrial-cmake-boilerplate\
    rsl\
    ruckig\
    sdformat-test-files\
    sdformat-urdf\
    sdformat-vendor\
    sdl2-vendor\
    sqlite3-vendor\
    srdfdom\
    sros2\
    steering-controllers-library\
    stomp\
    tcb-span\
    tl-expected\
    topic-tools\
    topic-tools-interfaces\
    transmission-interface\
    tricycle-controller\
    tricycle-steering-controller\
    urdfdom\
    urdfdom-py\
    velocity-controllers\
    vision-opencv\
    warehouse-ros\
    warehouse-ros-sqlite\
    xacro\
    yaml-cpp-vendor\
"

# rviz2
# rviz-assimp-vendor
# rviz-common
# rviz-default-plugins
# rviz-ogre-vendor
# rviz-rendering
# rviz-rendering-tests
# rviz-visual-testing-framework
# gz-cmake-vendor
# gz-math-vendor
# gz-tools-vendor
# gz-utils-vendor
# python-qt-binding
# py-binding-tools
# joint-state-publisher-gui
# moveit-resources-fanuc-description
# moveit-resources-fanuc-moveit-config
# moveit-resources-panda-description
# moveit-resources-panda-moveit-config
# moveit-resources-pr2-description
