# Copyright (c) 2020-2021 LG Electronics, Inc.

DESCRIPTION = "All non-test packages for the target from files/jazzy/cache.yaml"
LICENSE = "MIT"

# ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_* variables are MACHINE specific
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup
inherit ros_distro_jazzy

PACKAGES = "${PN}"

RDEPENDS:${PN} = "${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES}"

# Remove desktop
RDEPENDS:${PN}:remove = "desktop"
RDEPENDS:${PN}:remove = "desktop-full"

# Renamed to fuse-ros and fuse-ros-doc in recipes-bbappends/fuse to avoid conflict with
# meta-filesystems/recipes-support/fuse/fuse_2.9.9.bb
RDEPENDS:${PN}:remove = "fuse fuse-doc"

# Contains only dev, dbg and staticdev files, so PN is empty and not created
RDEPENDS:${PN}:remove = "test-osrf-testing-tools-cpp"

# It's empty package now, just providing dependency on platform zstd recipe
RDEPENDS:${PN}:remove = "zstd-vendor"

# It's empty package now, just providing dependency on platform python3-pybind11 recipe
RDEPENDS:${PN}:remove = "pybind11-vendor"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'mongodb', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MONGODB}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MONGODB = " \
    run-ompl-constrained-planning \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'mongodb-legacy-cxx-driver', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MONGODB_LEGACY_CXX_DRIVER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MONGODB_LEGACY_CXX_DRIVER = " \
    run-ompl-constrained-planning \
    turtlebot3-manipulation-moveit-config \
    warehouse-ros-mongo \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'cwiid', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CWIID}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CWIID = " \
    wiimote \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'libspnav', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBSPNAV}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBSPNAV = " \
    spacenav \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'cargo', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CARGO}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CARGO = " \
    zenoh-bridge-dds \
"

# alternative not yet supported implementation for fastrtps
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CONNEXT}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CONNEXT = " \
    connext-cmake-module \
    rmw-connext-cpp \
    rmw-connext-shared-cpp \
    rmw-connextdds-common \
    rmw-connextdds \
    rosidl-typesupport-connext-c \
    rosidl-typesupport-connext-cpp \
    rti-connext-dds-cmake-module \
"

# alternative not yet supported implementation for fastrtps
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gurumdds', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GURUMDDS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GURUMDDS = " \
    gurumdds-cmake-module \
    rmw-gurumdds-cpp \
    rmw-gurumdds-shared-cpp \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'libomp', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBOMP}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBOMP = " \
    moveit-planners-ompl \
    moveit-planners \
    moveit-ros \
    moveit-runtime \
    moveit \
    nav2-mppi-controller \
    reach \
    reach-ros \
"

# Can't build these until we figure out how to build clang-format, clang-tidy without building all of clang.
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'clang', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CLANG}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CLANG = " \
    ament-clang-format \
    ament-clang-tidy \
    ament-cmake-clang-format \
    ament-cmake-clang-tidy \
    ffmpeg-image-transport \
    ouxt-lint-common \
    pinocchio \
    zenoh-bridge-dds \
"


RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'openni', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENNI}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENNI = " \
    mrpt2 \
    mrpt-path-planning \
    mola-launcher \
    mola-input-ros2 \
    mola-input-rawlog \
    mola-viz \
    mp2p-icp \
    mvsim \
    pose-cov-ops \
    rtabmap \
    rtabmap-ros \
"

# Needs work to launch qemu to run tests on image on build machine.
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'launch', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LAUNCH}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LAUNCH = " \
    launch-testing-ament-cmake \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'coinor-libipopt', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COINOR_LIBIPOPT}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COINOR_LIBIPOPT = " \
    control-box-rst \
    plansys2-bringup \
    plansys2-bt-actions \
    plansys2-domain-expert \
    plansys2-executor \
    plansys2-planner \
    plansys2-popf-plan-solver \
    plansys2-problem-expert \
    plansys2-terminal \
    plansys2-tests \
    plansys2-tools \
    popf \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'libqglviewer', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBQGLVIEWER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBQGLVIEWER = " \
    octovis \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ignition', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_IGNITION}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_IGNITION = " \
    as2-platform-ign-gazebo \
    as2-ign-gazebo-assets \
    clearpath-desktop \
    clearpath-gz \
    clearpath-nav2-demos \
    clearpath-simulator \
    clearpath-viz \
    crane-plus-moveit-config \
    color-names \
    dolly-ignition \
    dolly \
    fuse-tutorials \
    grid-map \
    grid-map-demos \
    gz-ros2-control \
    gz-ros2-control-demos \
    ign-ros2-control \
    ign-ros2-control-demos \
    ign-rviz \
    ign-rviz-common \
    ign-rviz-plugins \
    ignition-cmake2-vendor \
    ignition-math6-vendor \
    ignition-cmake2 \
    ignition-common4 \
    ignition-fortress \
    ignition-fuel-tools7 \
    ignition-gazebo6 \
    ignition-gui6 \
    ignition-launch5 \
    ignition-math6 \
    ignition-msgs8 \
    ignition-physics5 \
    ignition-plugin \
    ignition-rendering6 \
    ignition-sensors6 \
    ignition-tools1 \
    ignition-transport11 \
    ignition-utils1 \
    irobot-create-common-bringup \
    irobot-create-ignition-bringup \
    irobot-create-ignition-sim \
    irobot-create-ignition-plugins \
    irobot-create-ignition-toolbox \
    irobot-create-nodes \
    irobot-create-toolbox \
    kinova-gen3-6dof-robotiq-2f-85-moveit-config \
    kinova-gen3-7dof-robotiq-2f-85-moveit-config \
    kortex-description \
    leo-desktop \
    leo-viz \
    moveit \
    moveit-hybrid-planning \
    moveit-resources-prbt-moveit-config \
    moveit-ros \
    moveit-ros-visualization \
    moveit-setup-app-plugins \
    moveit-setup-assistant \
    moveit-setup-controllers \
    moveit-setup-core-plugins \
    moveit-setup-framework \
    moveit-setup-srdf-plugins \
    moveit-visual-tools \
    nav2-bringup \
    nav2-rviz-plugins \
    navigation2 \
    nmea-hardware-interface \
    octomap-rviz-plugins \
    pal-navigation-cfg \
    pal-navigation-cfg-bringup \
    pmb2-2dnav \
    pmb2-bringup \
    pmb2-description \
    pmb2-navigation \
    pmb2-robot \
    polygon-demos \
    raspimouse-description \
    raspimouse-navigation \
    raspimouse-ros2-examples \
    raspimouse-slam \
    raspimouse-slam-navigation \
    rmf-building-map-tools \
    rmf-building-sim-gz-plugins \
    rmf-robot-sim-gz-plugins \
    rmf-rosdev \
    rmf-traffic-editor-test-maps \
    rmf-visualization \
    rmf-visualization-rviz2-plugins \
    robotiq-description \
    ros-gz-bridge \
    ros-gz-image \
    ros-gz-sim \
    ros-gz-sim-demos \
    ros-gz \
    ros-ign \
    ros-ign-bridge \
    ros-ign-gazebo \
    ros-ign-gazebo-demos \
    ros-ign-image \
    rtabmap-demos \
    rtabmap-examples \
    rtabmap-launch \
    rtabmap-ros \
    rtabmap-rviz-plugins \
    rviz2 \
    rviz-default-plugins \
    rviz-satellite \
    rviz-visual-tools \
    sdformat \
    sdformat-urdf \
    simulation \
    slam-toolbox \
    tiago-2dnav \
    tiago-bringup \
    tiago-description \
    tiago-moveit-config \
    tiago-navigation \
    tiago-robot \
    turtlebot3 \
    turtlebot3-bringup \
    turtlebot3-manipulation-cartographer \
    turtlebot3-manipulation-description \
    turtlebot3-manipulation-navigation2 \
    turtlebot3-navigation2 \
    turtlebot4-navigation \
    turtlebot4-desktop \
    turtlebot4-ignition-bringup \
    turtlebot4-ignition-gui-plugins \
    turtlebot4-python-tutorials \
    turtlebot4-simulator \
    turtlebot4-tutorials \
    turtlebot4-viz \
    ur \
    ur-bringup \
    ur-calibration \
    ur-description \
    ur-moveit-config \
    ur-robot-driver \
    urdf-launch \
    urdf-tutorial \
    vision-msgs-rviz-plugins \
"

# Depends on mesa or libglu which requires opengl or vulkan DISTRO_FEATURE
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opengl', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL = " \
    color-names \
    desktop \
    dolly-gazebo \
    dolly \
    find-object-2d \
    freeglut \
    fuse \
    fuse-tutorials \
    glew \
    glfw \
    libg2o \
    librealsense2 \
    moveit-ros \
    moveit-ros-perception \
    moveit-ros-visualization \
    moveit-ros \
    moveit-runtime \
    moveit-visual-tools \
    moveit \
    multires-image \
    openni2 \
    openni2-camera \
    openvslam \
    pangolin \
    plotjuggler-ros \
    plotjuggler \
    pose-cov-ops \
    realsense-examples \
    realsense-node \
    realsense-ros \
    realsense2-camera \
    rig-reconfigure \
    rmf-visualization \
    rmf-visualization-rviz2-plugins \
    rtabmap \
    rtabmap-ros \
    run-move-group \
    run-moveit-cpp \
    rviz-common \
    rviz-default-plugins \
    rviz-2d-overlay-plugins \
    rviz-ogre-vendor \
    rviz-rendering \
    rviz-visual-tools \
    rviz2 \
    tiago-bringup \
    tiago-robot \
    tinyspline-vendor \
    turtlebot3-gazebo \
    turtlebot3-simulations \
    webots-ros2-epuck \
    webots-ros2-tiago \
    webots-ros2-universal-robot \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT5}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT5 = " \
    cartographer-rviz \
    color-names \
    desktop \
    desktop-full \
    dolly-gazebo \
    dolly \
    dual-arm-panda-moveit-config \
    fuse-ros \
    fuse-tutorials \
    fuse-viz \
    grid-map \
    grid-map-demos \
    grid-map-rviz-plugin \
    imu-tools \
    joint-state-publisher-gui \
    leo-viz \
    leo-desktop \
    mapviz \
    mapviz-plugins \
    microstrain-inertial-rqt \
    moveit-hybrid-planning \
    moveit-resources-panda-moveit-config \
    moveit-resources-prbt-moveit-config \
    moveit-resources \
    moveit-resources-panda-moveit-config \
    moveit-ros-perception \
    moveit-ros-visualization \
    moveit-ros \
    moveit-ros-visualization \
    moveit-runtime \
    moveit-setup-assistant \
    moveit-setup-controllers \
    moveit-setup-core-plugins \
    moveit-setup-framework \
    moveit-setup-app-plugins \
    moveit-setup-srdf-plugins \
    moveit \
    navigation2 \
    nav2-bringup \
    nav2-rviz-plugins \
    nav2-system-tests \
    nmea-hardware-interface \
    octomap-rviz-plugins \
    octovis \
    plansys2-problem-expert \
    plansys2-tools \
    plotjuggler-ros \
    plotjuggler \
    pmb2-2dnav \
    pmb2-bringup \
    pmb2-description \
    pmb2-navigation \
    pmb2-robot \
    polygon-rviz-plugins \
    python-qt-binding \
    py-trees-js \
    qt-dotgraph \
    qt-gui \
    qt-gui-app \
    qt-gui-core \
    qt-gui-cpp \
    qt-gui-py-common \
    ros-image-to-qimage \
    rmf-demos \
    rmf-demos-assets \
    rmf-demos-gz \
    rmf-demos-ign \
    rmf-building-sim-gazebo-plugins \
    rmf-building-sim-ignition-plugins \
    rmf-robot-sim-gazebo-plugins \
    rmf-robot-sim-ignition-plugins \
    rmf-traffic-editor \
    rmf-visualization \
    rmf-visualization-rviz2-plugins \
    rqt-action \
    rqt-bag \
    rqt-bag-plugins \
    rqt-common-plugins \
    rqt-console \
    rqt-controller-manager \
    rqt-gauges \
    rqt-gui \
    rqt-gui-py \
    rqt-gui-cpp \
    rqt-graph \
    rqt-image-overlay \
    rqt-image-overlay-layer \
    rqt-image-view \
    rqt-joint-trajectory-controller \
    rqt-moveit \
    rqt-msg \
    rqt-plot \
    rqt-py-common \
    rqt-py-console \
    rqt-publisher \
    rqt-reconfigure \
    rqt-robot-dashboard \
    rqt-robot-monitor \
    rqt-robot-steering \
    rqt-runtime-monitor \
    rqt-service-caller \
    rqt-shell \
    rqt-srv \
    rqt-tf-tree \
    rqt-topic \
    rqt-top \
    rqt \
    rmf-building-sim-gazebo-plugins \
    rmf-building-sim-gz-plugins \
    rmf-building-sim-ignition-plugins \
    rmf-demos \
    rmf-demos-gz \
    rmf-demos-ign \
    rmf-robot-sim-gazebo-plugins \
    rmf-robot-sim-ignition-plugins \
    rmf-visualization \
    rmf-visualization-rviz2-plugins \
    rmf-traffic-editor \
    run-move-group \
    run-moveit-cpp \
    rviz-common \
    rviz-default-plugins \
    rviz-2d-overlay-plugins \
    rviz-imu-plugin \
    rviz-rendering-tests \
    rviz-rendering \
    rviz-visual-testing-framework \
    rviz2 \
    slam-toolbox \
    snowbot-operating-system \
    swri-console \
    tiago-bringup \
    tiago-description \
    tiago-robot \
    tile-map \
    turtlebot3 \
    turtlebot3-bringup \
    turtlebot3-gazebo \
    turtlebot3-navigation2 \
    turtlebot3-simulations \
    turtle-tf2-py \
    turtle-tf2-cpp \
    turtlebot3-gazebo \
    turtlebot3-simulations \
    turtlesim \
    ur \
    ur-bringup \
    ur-robot-driver \
    ur-calibration \
    ur-description \
    ur-moveit-config \
    urdf-tutorial \
    vision-msgs-layers \
    webots-ros2-epuck \
    webots-ros2-tiago \
    webots-ros2-universal-robot \
"

# OE won't let us build ffmpeg unless LICENSE_FLAGS_ACCEPTED contains "commercial" or "commercial_ffmpeg" or "ffmpeg".
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ffmpeg', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FFMPEG}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FFMPEG = " \
    mvsim \
    mrpt2 \
    usb-cam \
"

# OE won't let us build x264 unless LICENSE_FLAGS_ACCEPTED contains "commercial" or "commercial_x264" or "x264".
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'x264', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X264}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X264 = " \
    mvsim \
    mrpt2 \
    usb-cam \
"

# Recipes which need widgets enabled in qtbase PACKAGECONFIG which webOS OSE explicitly disables:
# meta-webos/recipes-qt/qt5/qtbase_git.bbappend:PACKAGECONFIG:remove = "widgets"
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5-widgets', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_QT5_WIDGETS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_QT5_WIDGETS = " \
    plotjuggler-ros \
    plotjuggler \
    rmf-traffic-editor \
    turtle-tf2-py \
    turtle-tf2-cpp \
    turtlesim \
"

# NB. gazebo-msgs is a dependency of non-Gazebo packages, so it doesn't appear here.
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GAZEBO}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GAZEBO = " \
    aws-robomaker-small-warehouse-world \
    crane-plus \
    crane-plus-control \
    crane-plus-description \
    crane-plus-examples \
    crane-plus-gazebo \
    dolly \
    dolly-gazebo \
    gazebo-plugins \
    gazebo11 \
    gazebo-ros-pkgs \
    gazebo-ros \
    gazebo-rosdev \
    gazebo-ros2-control \
    gazebo-ros2-control-demos \
    gazebo-ros2-control \
    gz-ros2-control \
    gz-ros2-control-demos \
    irobot-create-gazebo-bringup \
    irobot-create-gazebo-plugins \
    irobot-create-gazebo-sim \
    kortex-bringup \
    nav2-system-tests \
    pal-gazebo-plugins \
    pmb2-gazebo \
    pmb2-simulation \
    rmf-building-sim-gazebo-plugins \
    rmf-building-sim-gz-plugins \
    rmf-building-sim-gz-classic-plugins \
    rmf-demos \
    rmf-demos-assets \
    rmf-demos-gz \
    rmf-demos-ign \
    rmf-robot-sim-gazebo-plugins \
    rmf-robot-sim-gz-plugins \
    rmf-robot-sim-gz-classic-plugins \
    rmf-rosdev \
    tiago-gazebo \
    tiago-simulation \
    turtlebot3-gazebo \
    turtlebot3-manipulation \
    turtlebot3-manipulation-bringup \
    turtlebot3-manipulation-teleop \
    turtlebot3-simulations \
    urdf-sim-tutorial \
    velodyne-description \
    velodyne-simulator \
    velodyne-gazebo-plugins \
"

ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API:x86 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API:x86-64 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API:armv7a = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', 'rc-genicam-api rc-genicam-driver', '', d)}"
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API:armv7ve = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', 'rc-genicam-api rc-genicam-driver', '', d)}"
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API:aarch64 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API = "\
    rc-genicam-api \
    rc-genicam-driver \
"

ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_WEBOTS_ROS2_DRIVER:x86-64 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_WEBOTS_ROS2_DRIVER = "\
    webots-ros2-control \
    webots-ros2-driver \
    webots-ros2-tests \
"

ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_LIBPOINTMATCHER:aarch64 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_LIBPOINTMATCHER:x86-64 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_LIBPOINTMATCHER = "\
    libpointmatcher \
"

ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC = " \
    ${ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API} \
    ${ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_WEBOTS_ROS2_DRIVER} \
    ${ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_LIBPOINTMATCHER} \
"

RDEPENDS:${PN}:remove = "${ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC}"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'pyqt5', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYQT5}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYQT5 = " \
    desktop \
    dual-arm-panda-moveit-config \
    fuse-ros \
    fuse-viz \
    joint-state-publisher-gui \
    microstrain-inertial-rqt \
    moveit-resources-panda-moveit-config \
    moveit-resources \
    moveit-resources-panda-moveit-config \
    pmb2-2dnav \
    pmb2-bringup \
    pmb2-description \
    pmb2-navigation \
    pmb2-robot \
    python-qt-binding \
    qt-dotgraph \
    qt-gui-app \
    qt-gui-core \
    qt-gui-cpp \
    qt-gui-py-common \
    qt-gui \
    rosmon \
    rqt-action \
    rqt-bag \
    rqt-bag-plugins \
    rqt-console \
    rqt-common-plugins \
    rqt-controller-manager \
    rqt-gauges \
    rqt-graph \
    rqt-gui-cpp \
    rqt-gui-py \
    rqt-gui \
    rqt-image-view \
    rqt-joint-trajectory-controller \
    rqt-moveit \
    rqt-msg \
    rqt-plot \
    rqt-publisher \
    rqt-py-common \
    rqt-py-console \
    rqt-reconfigure \
    rqt-robot-dashboard \
    rqt-robot-monitor \
    rqt-robot-steering \
    rqt-runtime-monitor \
    rqt-service-caller \
    rqt-shell \
    rqt-srv \
    rqt-topic \
    rqt-top \
    rqt \
    run-move-group \
    run-moveit-cpp \
    tiago-description \
"

# do_compile failures
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt-gui-cpp', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_QT_GUI_CPP}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_QT_GUI_CPP = " \
    plansys2-tools \
    qt-gui-core \
    qt-gui-cpp \
    rosmon \
    rqt-gui-cpp \
    rqt \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'self-test', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SELF_TEST}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SELF_TEST = " \
    self-test \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'x11', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X11}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X11 = " \
    adwaita-icon-theme \
    color-names \
    desktop \
    dolly-gazebo \
    dolly \
    fuse \
    libg2o \
    moveit-ros-visualization \
    moveit-ros \
    moveit-ros-perception \
    moveit-ros-visualization \
    moveit-runtime \
    moveit-visual-tools \
    moveit \
    mrpt2 \
    mvsim \
    navigation2 \
    nav2-bringup \
    nav2-rviz-plugins \
    nav2-system-tests \
    openvslam \
    pmb2-2dnav \
    rmf-visualization \
    rmf-visualization-rviz2-plugins \
    rtabmap \
    rtabmap-ros \
    run-move-group \
    run-moveit-cpp \
    rviz2 \
    rviz-common \
    rviz-default-plugins \
    rviz-2d-overlay-plugins \
    rviz-ogre-vendor \
    rviz-rendering \
    rviz-visual-tools \
    slam-toolbox \
    tango-icons-vendor \
    tiago-bringup \
    tiago-robot \
    turtlebot3-gazebo \
    turtlebot3-simulations \
    visp \
    webots-ros2-epuck \
    webots-ros2-tiago \
    webots-ros2-universal-robot \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'glfw', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GLFW}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GLFW = " \
    librealsense2 \
    pose-cov-ops \
    realsense-examples \
    realsense-node \
    realsense-ros \
    realsense2-camera \
    rig-reconfigure \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ros1', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROS1}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROS1 = " \
    rosbag2-bag-v2-plugins \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'babeltrace-python', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_BABELTRACE_PYTHON}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_BABELTRACE_PYTHON = " \
    ros2trace-analysis \
    tracetools-analysis \
    tracetools-read \
    tracetools-test \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'webots-python-modules', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_WEBOTS_PYTHON_MODULES}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_WEBOTS_PYTHON_MODULES = " \
    webots-ros2 \
    webots-ros2-abb \
    webots-ros2-control \
    webots-ros2-core \
    webots-ros2-demos \
    webots-ros2-desktop \
    webots-ros2-driver \
    webots-ros2-epuck \
    webots-ros2-examples \
    webots-ros2-importer \
    webots-ros2-mavic \
    webots-ros2-tesla \
    webots-ros2-tiago \
    webots-ros2-turtlebot \
    webots-ros2-tutorials \
    webots-ros2-universal-robot \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'swri', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SWRI}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SWRI = " \
    swri-image-util \
    swri-roscpp \
    swri-route-util \
    swri-transform-util \
"

# do_configure failures
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lanelet2-traffic-rules', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LANELET2_TRAFFIC_RULES}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LANELET2_TRAFFIC_RULES = " \
    lanelet2-examples \
    lanelet2-python \
    lanelet2-routing \
    lanelet2-traffic-rules \
    lanelet2-validation \
    lanelet2 \
"
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lanelet2-io', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LANELET2_IO}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LANELET2_IO = " \
    lanelet2-io \
    lanelet2-projection \
"

# do_compile failures
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lanelet2-core', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LANELET2_CORE}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LANELET2_CORE = " \
    lanelet2-core \
    lanelet2-maps \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'libopen3d', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBOPEN3D}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBOPEN3D = " \
    open3d-conversions \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'scipy', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SCIPY}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_SCIPY = " \
    proxsuite \
    slider-publisher \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'hunter', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_HUNTER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_HUNTER = " \
    depthai \
    depthai-bridge \
    depthai-examples \
    depthai-filters \
    depthai-ros \
    depthai-ros-driver \
    depthai-ros-msgs \
    turtlebot4-bringup \
    turtlebot4-robot \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'jupyter', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_JUPYTER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_JUPYTER = " \
    ros2trace-analysis \
    tracetools-analysis \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'wireguard', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_WIREGUARD}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_WIREGUARD = " \
    fogros2 \
    fogros2-examples \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'aws', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_AWS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_AWS = " \
    aws-robomaker-small-warehouse-world \
    aws-sdk-cpp-vendor \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'mrpt2', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MRPT2}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MRPT2 = " \
    mola-imu-preintegration \
    mola-input-euroc-dataset \
    mola-input-kitti-dataset \
    mola-input-rawlog \
    mola-input-ros2 \
    mola-kernel \
    mola-launcher \
    mola-viz \
    mola-yaml \
    mp2p-icp \
    mrpt-path-planning \
    mrpt2 \
    mvsim \
    pose-cov-ops \
"
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'g2o', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_G2O}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_G2O = " \
    rtabmap \
    rtabmap-conversions \
    rtabmap-demos \
    rtabmap-examples \
    rtabmap-launch \
    rtabmap-msgs \
    rtabmap-odom \
    rtabmap-python \
    rtabmap-ros \
    rtabmap-rviz-plugins \
    rtabmap-slam \
    rtabmap-sync \
    rtabmap-util \
    rtabmap-viz \
"

RDEPENDS:${PN}:remove = "vitis-common"

# sophus does not directly provide any runtime components
RDEPENDS:${PN}:remove = "sophus"

# websocketpp does not directly provide any runtime components
RDEPENDS:${PN}:remove = "websocketpp"

RDEPENDS:${PN}:remove = "wireless-watcher"

# metavision-driver depends ont he Metavision SDK by Prophesee
RDEPENDS:${PN}:remove = "metavision-driver"

# as2-platform-dji-osdk hasn't been updated in 2 years
# it uses deprecated APIs and fails to build against the latest ffmpeg
RDEPENDS:${PN}:remove = "as2-platform-dji-osdk"

# novatel-oem7-driver needs libCommon.a from an SDK
RDEPENDS:${PN}:remove = "novatel-oem7-driver"

# usb-cam needs updating to the latest ffmpeg APIs
RDEPENDS:${PN}:remove = "usb-cam"

# spinnaker-camera-driver requires the spinnaker SDK
RDEPENDS:${PN}:remove = "spinnaker-camera-driver"

# septentrio-gnss-driver
RDEPENDS:${PN}:remove = "septentrio-gnss-driver"

# behaviortree-cpp conflicts with behaviortree-cpp-v3
# but it has no dependencies
RDEPENDS:${PN}:remove = "behaviortree-cpp"

# smacc2 builds on ROS 2 Buildfarm fail for Rolling
RDEPENDS:${PN}:remove = "smacc2"
RDEPENDS:${PN}:remove = "smacc2-msgs"

# novatel-gps-driver
RDEPENDS:${PN}:remove = "novatel-gps-driver"

# canopen-tests
RDEPENDS:${PN}:remove = "canopen-tests"

# nao-lola
# "Please use nao_lola_client. nao_lola will be removed in K-turtle."
RDEPENDS:${PN}:remove = "nao-lola"
