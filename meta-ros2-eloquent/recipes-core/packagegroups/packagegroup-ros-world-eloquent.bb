# Copyright (c) 2019-2020 LG Electronics, Inc.

DESCRIPTION = "All non-test packages for the target from files/eloquent/cache.yaml"
LICENSE = "MIT"

# ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_* variables are MACHINE specific
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup
inherit ros_distro_eloquent

PACKAGES = "${PN}"

RDEPENDS_${PN} = "${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES}"

# Contains only dev, dbg and staticdev files, so PN is empty and not created
RDEPENDS_${PN}_remove = "sophus"

# Contains only dev, dbg and staticdev files, so PN is empty and not created
RDEPENDS_${PN}_remove = "test-osrf-testing-tools-cpp"

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
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opensplice', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENSPLICE}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENSPLICE = " \
    opensplice-cmake-module \
    rmw-opensplice-cpp \
    rosidl-typesupport-opensplice-c \
    rosidl-typesupport-opensplice-cpp \
"
# Can't build these until we figure out how to build clang-format, clang-tidy without building all of clang.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'clang', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CLANG}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CLANG = " \
    ament-clang-format \
    ament-clang-tidy \
    ament-cmake-clang-format \
    ament-cmake-clang-tidy \
"
# Depends on python3-docker which is available in meta-virtualization, but we don't want to add the
# dependency on this layer to meta-ros yet
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'docker', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_DOCKER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_DOCKER = " \
    cross-compile \
"
# Needs work to launch qemu to run tests on image on build machine.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'launch', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LAUNCH}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LAUNCH = " \
    launch-testing-ament-cmake \
"
# recipes depending on python3-matplotlib
# there is python2 version in meta-ros-common/recipes-devtools/python/python-matplotlib_2.1.1.bb
# but no python3 version yet
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python3-matplotlib', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON3_MATPLOTLIB}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYTHON3_MATPLOTLIB = " \
    desktop \
    rqt-common-plugins \
    rqt-plot \
"
# Depends on coin-or libcbc for which we don't have recipes yet
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'coin-or', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COIN_OR}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COIN_OR = " \
    plansys2-bringup \
    plansys2-executor \
    plansys2-multidomain-example \
    plansys2-patrol-navigation-example \
    plansys2-simple-example \
    plansys2-terminal \
    popf \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'coinor-libipopt', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COINOR_LIBIPOPT}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COINOR_LIBIPOPT = " \
    control-box-rst \
"

# Not compatible with newer libftdi included in meta-oe: https://github.com/kobuki-base/kobuki_ftdi/issues/3
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'kobuki-ftdi', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_KOBUKI_FTDI}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_KOBUKI_FTDI = " \
    kobuki-ftdi \
"
# recipes depending on openvdb and openexr for which we don't have recipes yet
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'openvdb-openexr', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENVDB_OPENEXR}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENVDB_OPENEXR = " \
    spatio-temporal-voxel-layer \
"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'pyqt5', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYQT5}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYQT5 = " \
    joint-state-publisher-gui \
    py-trees-js \
    py-trees-ros-tutorials \
    py-trees-ros-viewer \
    python-qt-binding \
    qt-dotgraph \
    qt-gui \
    qt-gui-app \
    qt-gui-core \
    qt-gui-cpp \
    qt-gui-py-common \
    rqt \
    rqt-action \
    rqt-console \
    rqt-graph \
    rqt-gui \
    rqt-gui-cpp \
    rqt-gui-py \
    rqt-image-view \
    rqt-moveit \
    rqt-msg \
    rqt-publisher \
    rqt-py-common \
    rqt-py-console \
    rqt-reconfigure \
    rqt-robot-monitor \
    rqt-robot-steering \
    rqt-service-caller \
    rqt-shell \
    rqt-srv \
    rqt-tf-tree \
    rqt-top \
    rqt-topic \
"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'x11', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X11}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X11 = " \
    nav2-rviz-plugins \
    mapviz \
    mapviz-plugins \
    multires-image \
    rviz-common \
    rviz-default-plugins \
    rviz-ogre-vendor \
    rviz-rendering \
    rviz2 \
    slam-toolbox \
    tile-map \
    turtlebot3-bringup \
    turtlebot3 \
    webots-ros2-demos \
    webots-ros2-epuck \
    webots-ros2-tiago \
    webots-ros2-universal-robot \
    webots-ros2 \
"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT5}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT5 = " \
    desktop \
    joint-state-publisher-gui \
    nav2-rviz-plugins \
    mapviz \
    mapviz-plugins \
    multires-image \
    py-trees-js \
    py-trees-ros-tutorials \
    py-trees-ros-viewer \
    python-qt-binding \
    qt-dotgraph \
    qt-gui \
    qt-gui-app \
    qt-gui-core \
    qt-gui-cpp \
    qt-gui-py-common \
    rqt \
    rqt-action \
    rqt-common-plugins \
    rqt-console \
    rqt-graph \
    rqt-gui \
    rqt-gui-cpp \
    rqt-gui-py \
    rqt-image-view \
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
    rqt-tf-tree \
    rqt-top \
    rqt-topic \
    rviz-common \
    rviz-default-plugins \
    rviz-rendering \
    rviz2 \
    slam-toolbox \
    swri-console \
    tile-map \
    turtlebot3-bringup \
    turtlebot3 \
    turtlesim \
    webots-ros2-demos \
    webots-ros2-epuck \
    webots-ros2-tiago \
    webots-ros2-universal-robot \
    webots-ros2 \
"
# Recipes which need widgets enabled in qtbase PACKAGECONFIG which webOS OSE explicitly disables:
# meta-webos/recipes-qt/qt5/qtbase_git.bbappend:PACKAGECONFIG_remove = "widgets"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5-widgets', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_QT5_WIDGETS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_QT5_WIDGETS = " \
    swri-console \
    turtlesim \
"
# NB. gazebo-msgs is a dependency of non-Gazebo packages, so it doesn't appear here.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GAZEBO}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GAZEBO = " \
    dolly \
    dolly-gazebo \
    gazebo-plugins \
    gazebo-ros \
    gazebo-ros-pkgs \
    gazebo-rosdev \
    nav2-system-tests \
"
# Depends on libqt4-dev from https://git.yoctoproject.org/cgit/cgit.cgi/meta-qt4
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt4', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT4}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT4 = " \
    octovis \
"
# Depends on mesa or libglu which requires opengl or vulkan DISTRO_FEATURE
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opengl', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL = " \
    libg2o \
    rviz-ogre-vendor \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'rc-dynamics-api', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_RC_DYNAMICS_API}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_RC_DYNAMICS_API = " \
    rc-dynamics-api \
"

ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API_x86 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API_x86_64 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API_armv7a = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', 'rc-genicam-api', '', d)}"
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API_armv7ve = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', 'rc-genicam-api', '', d)}"
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API_aarch64 = ""
ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API = "\
    rc-genicam-api \
"

ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC = " \
    ${ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_RC_GENICAM_API} \
"

RDEPENDS_${PN}_remove = "${ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC}"

# do_configure failures
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lanelet2-traffic-rules', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LANELET2_TRAFFIC_RULES}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LANELET2_TRAFFIC_RULES = " \
    lanelet2-examples \
    lanelet2-python \
    lanelet2-routing \
    lanelet2-traffic-rules \
    lanelet2-validation \
    lanelet2 \
"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lanelet2-io', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LANELET2_IO}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LANELET2_IO = " \
    lanelet2-io \
    lanelet2-projection \
"
