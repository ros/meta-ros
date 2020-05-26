# Copyright (c) 2020 LG Electronics, Inc.

DESCRIPTION = "All non-test packages for the target from files/foxy/cache.yaml"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_foxy

PACKAGES = "${PN}"

RDEPENDS_${PN} = "${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES}"

# alternative not yet supported implementation for fastrtps
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CONNEXT}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CONNEXT = " \
    connext-cmake-module \
    rmw-connext-cpp \
    rmw-connext-shared-cpp \
    rosidl-typesupport-connext-c \
    rosidl-typesupport-connext-cpp \
"
# Can't build these until we figure out how to build clang-format, clang-tidy without building all of clang.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'clang', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CLANG}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_CLANG = " \
    ament-clang-format \
    ament-clang-tidy \
    ament-cmake-clang-format \
    ament-cmake-clang-tidy \
"

# Needs work to launch qemu to run tests on image on build machine.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'launch', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LAUNCH}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LAUNCH = " \
    launch-testing-ament-cmake \
"

# Depends on mesa or libglu which requires opengl or vulkan DISTRO_FEATURE
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opengl', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL = " \
    rviz-ogre-vendor \
    librealsense2 \
    realsense-examples \
    realsense-node \
    realsense-ros \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT5}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT5 = " \
    desktop \
    turtlesim \
    rqt-gui-cpp \
    rviz-common \
    rviz-rendering-tests \
    rqt-py-common \
    python-qt-binding \
    qt-gui \
    rviz-rendering \
    rviz-visual-testing-framework \
    qt-gui-cpp \
    rviz-default-plugins \
    rviz2 \
    qt-gui-core \
    rqt-gui \
    rqt-gui-py \
    rqt-topic \
    rqt-graph \
    rqt-py-console \
    rqt-srv \
    rqt-robot-steering \
    rqt-service-caller \
    rqt-shell \
    rqt-publisher \
    rqt-plot \
    rqt \
    rqt-console \
    rqt-top \
    rqt-action \
    rqt-msg \
    rqt-reconfigure \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'pyqt5', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYQT5}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYQT5 = " \
    qt-gui-core \
    qt-gui-cpp \
    rosmon \
    rqt-gui-cpp \
    rqt \
"

# do_compile failures
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt-gui-cpp', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_QT_GUI_CPP}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_QT_GUI_CPP = " \
    qt-gui-core \
    qt-gui-cpp \
    rosmon \
    rqt-gui-cpp \
    rqt \
"
