# Copyright (c) 2020 LG Electronics, Inc.

DESCRIPTION = "All non-test packages for the target from files/foxy/cache.yaml"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_foxy

PACKAGES = "${PN}"

RDEPENDS_${PN} = "${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES}"

# Contains only dev, dbg and staticdev files, so PN is empty and not created
RDEPENDS_${PN}_remove = "sophus"

# Contains only dev, dbg and staticdev files, so PN is empty and not created
RDEPENDS_${PN}_remove = "test-osrf-testing-tools-cpp"

# It's empty package now, just providing dependency on platform zstd recipe
RDEPENDS_${PN}_remove = "zstd-vendor"

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

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'coinor-libipopt', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COINOR_LIBIPOPT}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_COINOR_LIBIPOPT = " \
    control-box-rst \
    popf \
"

# Depends on mesa or libglu which requires opengl or vulkan DISTRO_FEATURE
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opengl', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL = " \
    desktop \
    libg2o \
    librealsense2 \
    realsense-examples \
    realsense-node \
    realsense-ros \
    ros-ign \
    ros-ign-gazebo-demos \
    rviz-common \
    rviz-default-plugins \
    rviz-ogre-vendor \
    rviz-rendering \
    rviz2 \
    webots-ros2-epuck \
    webots-ros2-tiago \
    webots-ros2-universal-robot \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT5}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT5 = " \
    desktop \
    joint-state-publisher-gui \
    nav2-rviz-plugins \
    octovis \
    python-qt-binding \
    py-trees-js \
    py-trees-ros-tutorials \
    py-trees-ros-viewer \
    qt-dotgraph \
    qt-gui \
    qt-gui-app \
    qt-gui-core \
    qt-gui-cpp \
    qt-gui-py-common \
    ros-ign \
    ros-ign-gazebo-demos \
    rqt-action \
    rqt-common-plugins \
    rqt-console \
    rqt-gui \
    rqt-gui-py \
    rqt-gui-cpp \
    rqt-graph \
    rqt-image-view \
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
    rqt-topic \
    rqt-top \
    rqt \
    rviz-common \
    rviz-default-plugins \
    rviz-rendering-tests \
    rviz-rendering \
    rviz-visual-testing-framework \
    rviz2 \
    slam-toolbox \
    turtlesim \
    webots-ros2-epuck \
    webots-ros2-tiago \
    webots-ros2-universal-robot \
"

# OE won't let us build ffmpeg unless LICENSE_FLAGS_WHITELIST contains "commercial" or "commercial_ffmpeg" or "ffmpeg".
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ffmpeg', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FFMPEG}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FFMPEG = " \
    mrpt2 \
"

# OE won't let us build x264 unless LICENSE_FLAGS_WHITELIST contains "commercial" or "commercial_x264" or "x264".
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'x264', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X264}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X264 = " \
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
    nav2-system-tests \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'pyqt5', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYQT5}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYQT5 = " \
    desktop \
    joint-state-publisher-gui \
    python-qt-binding \
    py-trees-js \
    py-trees-ros-tutorials \
    py-trees-ros-viewer \
    qt-dotgraph \
    qt-gui-app \
    qt-gui-core \
    qt-gui-cpp \
    qt-gui-py-common \
    qt-gui \
    rosmon \
    ros-ign \
    ros-ign-gazebo-demos \
    rqt-action \
    rqt-console \
    rqt-common-plugins \
    rqt-graph \
    rqt-gui-cpp \
    rqt-gui-py \
    rqt-gui \
    rqt-image-view \
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

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'x11', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X11}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_X11 = " \
    desktop \
    nav2-rviz-plugins \
    ros-ign \
    ros-ign-gazebo-demos \
    rviz2 \
    rviz-common \
    rviz-default-plugins \
    rviz-ogre-vendor \
    rviz-rendering \
    slam-toolbox \
    webots-ros2-epuck \
    webots-ros2-tiago \
    webots-ros2-universal-robot \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'glfw', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GLFW}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GLFW = " \
    librealsense2 \
    realsense-examples \
    realsense-node \
    realsense-ros \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ros1', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROS1}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_ROS1 = " \
    rosbag2-bag-v2-plugins \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'webots-python-modules', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_WEBOTS_PYTHON_MODULES}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_WEBOTS_PYTHON_MODULES = " \
    webots-ros2 \
    webots-ros2-abb \
    webots-ros2-demos \
    webots-ros2-desktop \
    webots-ros2-core \
    webots-ros2-examples \
    webots-ros2-importer \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'libqglviewer', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBQGLVIEWER}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LIBQGLVIEWER = " \
    octovis \
"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ignition', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_IGNITION}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_IGNITION = " \
    ros-ign-bridge \
    ros-ign-gazebo \
    ros-ign-image \
"
