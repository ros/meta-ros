# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2022 Wind River Systems, Inc.

DESCRIPTION = "All non-test packages for the target from files/humble/cache.yaml"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_humble

PACKAGES = "${PN}"

RDEPENDS_${PN} = "${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES}"

# Contains only dev, dbg and staticdev files, so PN is empty and not created
RDEPENDS_${PN}_remove = "test-osrf-testing-tools-cpp"

# It's empty package now, just providing dependency on platform zstd recipe
RDEPENDS_${PN}_remove = "zstd-vendor"

# It's empty package now, just providing dependency on platform python3-pybind11 recipe
RDEPENDS:${PN}:remove = "pybind11-vendor"

# Depends on unavailable python3-shapely
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python3-shapely', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON3_SHAPELY}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON3_SHAPELY = " \
    rmf-building-map-tools \
    rmf-demos-maps \
    rmf-building-map-tools \
    rmf-traffic-editor-test-maps \
"
# Depends on unavailable python3-flask-cors
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python3-flask-cors', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON3_FLASK_CORS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON3_FLASK_CORS = " \
    rmf-demos-panel \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'rqt-runtime-monitor', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_RQT_RUNTIME_MONITOR}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_RQT_RUNTIME_MONITOR = " \
    rqt-runtime-monitor \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'mongodb', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MONGODB}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MONGODB = " \
    run-ompl-constrained-planning \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'mongodb-legacy-cxx-driver', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MONGODB_LEGACY_CXX_DRIVER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_MONGODB_LEGACY_CXX_DRIVER = " \
    run-ompl-constrained-planning \
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

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'clang', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CLANG}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CLANG = " \
    zenoh-bridge-dds \
"

# alternative not yet supported implementation for fastrtps
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CONNEXT}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CONNEXT = " \
    connext-cmake-module \
    rmw-connext-cpp \
    rmw-connext-shared-cpp \
    rosidl-typesupport-connext-c \
    rosidl-typesupport-connext-cpp \
"

# alternative not yet supported implementation for fastrtps
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gurumdds', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GURUMDDS}', '', d)}"
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
"

# Can't build these until we figure out how to build clang-format, clang-tidy without building all of clang.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'clang', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CLANG}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CLANG = " \
    ament-clang-format \
    ament-clang-tidy \
    ament-cmake-clang-format \
    ament-cmake-clang-tidy \
    ouxt-lint-common \
    pinocchio \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'openni', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENNI}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENNI = " \
    rtabmap \
    rtabmap-ros \
"

# Needs work to launch qemu to run tests on image on build machine.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'launch', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LAUNCH}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LAUNCH = " \
    launch-testing-ament-cmake \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'coinor-libipopt', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COINOR_LIBIPOPT}', '', d)}"
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
    popf \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'libqglviewer', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBQGLVIEWER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBQGLVIEWER = " \
    octovis \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ignition', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_IGNITION}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_IGNITION = " \
    dolly-ignition \
    dolly \
    ign-rviz \
    ign-rviz-common \
    ign-rviz-plugins \
    ignition-cmake2-vendor \
    ignition-math6-vendor \
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
    simulation \
"

# Depends on mesa or libglu which requires opengl or vulkan DISTRO_FEATURE
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opengl', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL = " \
    color-names \
    desktop \
    libg2o \
    librealsense2 \
    moveit-ros \
    moveit-ros-perception \
    moveit-ros-visualization \
    moveit-ros \
    moveit-runtime \
    moveit-visual-tools \
    moveit \
    openvslam \
    plotjuggler-ros \
    plotjuggler \
    pose-cov-ops \
    realsense-examples \
    realsense-node \
    realsense-ros \
    realsense2-camera \
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
    rviz2 \
    tiago-bringup \
    tiago-robot \
    turtlebot3-gazebo \
    turtlebot3-simulations \
    webots-ros2-epuck \
    webots-ros2-tiago \
    webots-ros2-universal-robot \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT5}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT5 = " \
    cartographer-rviz \
    color-names \
    desktop \
    desktop-full \
    dolly-gazebo \
    dolly \
    grid-map \
    grid-map-demos \
    grid-map-rviz-plugin \
    imu-tools \
    joint-state-publisher-gui \
    leo-viz \
    leo-desktop \
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
    python-qt-binding \
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
    rqt-common-plugins \
    rqt-console \
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
    rqt-robot-monitor \
    rqt-robot-steering \
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

# OE won't let us build ffmpeg unless LICENSE_FLAGS_WHITELIST contains "commercial" or "commercial_ffmpeg" or "ffmpeg".
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ffmpeg', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FFMPEG}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FFMPEG = " \
    mvsim \
    mrpt2 \
"

# OE won't let us build x264 unless LICENSE_FLAGS_WHITELIST contains "commercial" or "commercial_x264" or "x264".
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'x264', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X264}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X264 = " \
    mvsim \
    mrpt2 \
"

# Recipes which need widgets enabled in qtbase PACKAGECONFIG which webOS OSE explicitly disables:
# meta-webos/recipes-qt/qt5/qtbase_git.bbappend:PACKAGECONFIG_remove = "widgets"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5-widgets', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_QT5_WIDGETS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_QT5_WIDGETS = " \
    turtlesim \
"

# NB. gazebo-msgs is a dependency of non-Gazebo packages, so it doesn't appear here.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GAZEBO}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GAZEBO = " \
    gazebo-plugins \
    gazebo-ros-pkgs \
    gazebo-ros \
    gazebo-rosdev \
    gazebo-ros2-control-demos \
    gazebo-ros2-control \
    pmb2-gazebo \
    pmb2-simulation \
    rmf-building-sim-gazebo-plugins \
    rmf-building-sim-gz-plugins \
    rmf-building-sim-gz-classic-plugins \
    rmf-demos \
    rmf-demos-assets \
    rmf-demos-gz \
    rmf-demos-ign \
    rmf-building-sim-gazebo-plugins \
    rmf-robot-sim-gazebo-plugins \
    rmf-robot-sim-gz-plugins \
    rmf-robot-sim-gz-classic-plugins \
    turtlebot3-gazebo \
    turtlebot3-simulations \
    velodyne-description \
    velodyne-simulator \
    velodyne-gazebo-plugins \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'pyqt5', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYQT5}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYQT5 = " \
    desktop \
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
    rqt-console \
    rqt-common-plugins \
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
    rqt-robot-monitor \
    rqt-robot-steering \
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
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt-gui-cpp', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_QT_GUI_CPP}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_QT_GUI_CPP = " \
    plansys2-tools \
    qt-gui-core \
    qt-gui-cpp \
    rosmon \
    rqt-gui-cpp \
    rqt \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'x11', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X11}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X11 = " \
    color-names \
    desktop \
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
    tiago-bringup \
    tiago-robot \
    turtlebot3-gazebo \
    turtlebot3-simulations \
    webots-ros2-epuck \
    webots-ros2-tiago \
    webots-ros2-universal-robot \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'glfw', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GLFW}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GLFW = " \
    librealsense2 \
    pose-cov-ops \
    realsense-examples \
    realsense-node \
    realsense-ros \
    realsense2-camera \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ros1', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROS1}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROS1 = " \
    rosbag2-bag-v2-plugins \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'babeltrace-python', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_BABELTRACE_PYTHON}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_BABELTRACE_PYTHON = " \
    ros2trace-analysis \
    tracetools-analysis \
    tracetools-read \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'webots-python-modules', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_WEBOTS_PYTHON_MODULES}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_WEBOTS_PYTHON_MODULES = " \
    webots-ros2 \
    webots-ros2-abb \
    webots-ros2-control \
    webots-ros2-demos \
    webots-ros2-desktop \
    webots-ros2-driver \
    webots-ros2-core \
    webots-ros2-examples \
    webots-ros2-importer \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'rclcpp-4', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OLD_RCLCPP}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OLD_RCLCPP = " \
    image-pipeline \
    image-publisher \
    image-rotate \
    image-view \
    stereo-image-proc \
    system-modes-examples \

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
    slider-publisher \
"

RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'hunter', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_HUNTER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_HUNTER = " \
    depthai \
    depthai-bridge \
    depthai-examples \
    depthai-ros \
    depthai-ros-msgs \
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

RDEPENDS:${PN}:remove = "vitis-common"

# sophus does not directly provide any runtime components
RDEPENDS:${PN}:remove = "sophus"

# websocketpp does not directly provide any runtime components
RDEPENDS:${PN}:remove = "websocketpp"
