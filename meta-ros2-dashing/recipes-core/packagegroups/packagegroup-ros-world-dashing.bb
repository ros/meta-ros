# Copyright (c) 2019-2020 LG Electronics, Inc.

DESCRIPTION = "All non-test packages for the target from files/dashing/cache.yaml"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_dashing

PACKAGES = "${PN}"

RDEPENDS_${PN} = "${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES}"

# Contains only dev, dbg and staticdev files, so PN is empty and not created
RDEPENDS_${PN}_remove = "cloudwatch-metrics-common"

# Contains only dev, dbg and staticdev files, so PN is empty and not created
RDEPENDS_${PN}_remove = "lex-common"

# Contains only dev, dbg and staticdev files, so PN is empty and not created
RDEPENDS_${PN}_remove = "sophus"

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
    launch-ros-sandbox \
"
# Needs work to launch qemu to run tests on image on build machine.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'launch', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LAUNCH}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_LAUNCH = " \
    launch-testing-ament-cmake \
"
# behaviortree-cpp-v3 and behaviortree-cpp are mutually exclusive because they install files in the same locations. Unlike
# behaviortree-cpp, nothing depends on behaviortree-cpp-v3, so exclude it.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'behaviortree-cpp-v3', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_BEHAVIORTREE_CPP_V3}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_BEHAVIORTREE_CPP_V3 = " \
    behaviortree-cpp-v3 \
"
# There is recipe for glfw in meta-oe in dunfell:
# http://cgit.openembedded.org/meta-openembedded/commit/meta-oe/recipes-core/glfw/glfw_3.3.bb?id=a7464eaa69a7ee4734001aab2e232102e7135772
# but we don't have a backports layer from dunfell yet, lets skip it for now
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'glfw', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GLFW}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GLFW = " \
    librealsense2 \
    realsense-ros2-camera \
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
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gst-python', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GST_PYTHON}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_GST_PYTHON = " \
    tts \
"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'pyqt5', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYQT5}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_PYQT5 = " \
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
    rqt-msg \
    rqt-publisher \
    rqt-py-common \
    rqt-py-console \
    rqt-reconfigure \
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
    rviz-common \
    rviz-default-plugins \
    rviz-ogre-vendor \
    rviz-rendering \
    slam-toolbox \
"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT5}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT5 = " \
    desktop \
    nav2-rviz-plugins \
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
    rqt-msg \
    rqt-plot \
    rqt-publisher \
    rqt-py-common \
    rqt-py-console \
    rqt-reconfigure \
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
    slam-toolbox \
    turtlesim \
"
# OE won't let us build ffmpeg unless LICENSE_FLAGS_WHITELIST contains "commerical".
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ffmpeg', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FFMPEG}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_FFMPEG = " \
    h264-encoder-core \
    h264-video-encoder \
    web-video-server \
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
    gazebo-ros \
    gazebo-ros-pkgs \
    gazebo-rosdev \
    nav2-system-tests \
    turtlebot3-gazebo \
    turtlebot3-simulations \
"
# Depends on libqt4-dev from https://git.yoctoproject.org/cgit/cgit.cgi/meta-qt4
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt4', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT4}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT4 = " \
    octovis \
"
# Depends on mesa or libglu which requires opengl or vulkan DISTRO_FEATURE
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opengl', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL = " \
    librealsense2 \
    realsense-ros2-camera \
    rviz-ogre-vendor \
"

# There is unbuildable dependency on virtual/egl from gstreamer1.0-plugins-base because:
# 1) gstreamer1.0-plugins-base depends on virtual/egl because of "egl" PACKAGECONFIG
#
# 2) "egl" PACKAGECONFIG is enabled by
#    meta-raspberrypi/recipes-multimedia/gstreamer/gstreamer1.0-plugins-base_%.bbappend
#    PACKAGECONFIG_GL_rpi = "egl gles2"
#
#    without respecting the "opengl" in DISTRO_FEATURES like the recipe in oe-core does
#    openembedded-core/meta/recipes-multimedia/gstreamer/gstreamer1.0-plugins-base_1.14.4.bb:
#    PACKAGECONFIG_GL ?= "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gles2 egl', '', d)}"
#
# 3) virtual/egl is provided either by:
#    - userland (only without vc4graphics in MACHINE_FEATURES):
#      meta-raspberrypi/recipes-graphics/userland/userland_git.bb:PROVIDES += "${@bb.utils.contains("MACHINE_FEATURES", "vc4graphics", "", "virtual/libgles2 virtual/egl", d)}"
#    - mesa (selected with vc4graphics in MACHINE_FEATURES)
#      meta-raspberrypi/conf/machine/include/rpi-default-providers.inc:PREFERRED_PROVIDER_virtual/egl ?= "${@bb.utils.contains("MACHINE_FEATURES", "vc4graphics", "mesa", "userland", d)}"
#    - vc-graphics(-hardfp)
#      meta-raspberrypirecipes-graphics/vc-graphics/vc-graphics.inc:PROVIDES = "virtual/libgles2 virtual/egl"
#
# 4) vc-graphics(-hardfp) recipe are skipped in default setup, because with vc4graphics being
#    in MACHINE_FEATURES by default since:
#    https://github.com/agherzan/meta-raspberrypi/commit/690bdca57422447e49d4ef43862bf675e9acc28f
#    the PREFERRED_PROVIDER_virtual/libgles2 is set to mesa in:
#    conf/machine/include/rpi-default-providers.inc:PREFERRED_PROVIDER_virtual/libgles2 ?= "${@bb.utils.contains("MACHINE_FEATURES", "vc4graphics", "mesa", "userland", d)}"
#
#    resulting in skipping the other virtual/libgles2 providers:
#    vc-graphics-hardfp PROVIDES virtual/egl but was skipped: PREFERRED_PROVIDER_virtual/libgles2 set to mesa, not vc-graphics-hardfp
#    vc-graphics PROVIDES virtual/egl but was skipped: PREFERRED_PROVIDER_virtual/libgles2 set to mesa, not vc-graphics
#
# 5) mesa is skipped when neither opengl nor vulkan are in DISTRO_FEATURES
#
# 6) userland doesn't provide virtual/egl because we have the default vc4graphics
#    meta-raspberrypi/recipes-graphics/userland/userland_git.bb:PROVIDES += "${@bb.utils.contains("MACHINE_FEATURES", "vc4graphics", "", "virtual/libgles2 virtual/egl", d)}"
#    and it cannot be built anyway, because with the default vc4graphics it depends on libegl-mesa:
#    meta-raspberrypi/recipes-graphics/userland/userland_git.bb:RDEPENDS_${PN} += "${@bb.utils.contains("MACHINE_FEATURES", "vc4graphics", "libegl-mesa", "", d)}"
#    and libegl-mesa is provided only by mesa recipe from oe-core which in turn
#    requires either "opengl" or "vulkan" to be in DISTRO_FEATURES
#
# This causes a lot of unresolved dependencies in default setup with vc4graphics but without opengl.
# - with Yocto 2.6 Thud and older it worked, because vc4graphics wasn't enabled by default before:
#   https://github.com/agherzan/meta-raspberrypi/commit/690bdca57422447e49d4ef43862bf675e9acc28f
#
# To build these packages you have 3 options:
# A) Just add "opengl" to DISTRO_FEATURES and use the default vc4graphics with mesa providing virtual/egl
# B) Use DISABLE_VC4GRAPHICS added in
#    https://github.com/agherzan/meta-raspberrypi/commit/96c8459c9363cc6bf463aedf4d24f92a1ee7d6ba
#    to explicitly disable vc4graphics and use userland to provide virtual/egl
# C) Apply https://github.com/agherzan/meta-raspberrypi/pull/551 in meta-raspberrypi,
#    this part can be removed once upgrading to Yocto release with this applied
RDEPENDS_${PN}_remove_rpi = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'vc4graphics-without-opengl', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL_AND_VC4GRAPHICS}', '', d)}"
ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_OPENGL_AND_VC4GRAPHICS = " \
    apriltag-ros \
    compressed-depth-image-transport \
    compressed-image-transport \
    cv-bridge \
    depthimage-to-laserscan \
    image-geometry \
    image-tools \
    image-transport-plugins \
    intra-process-demo \
    object-analytics-node \
    object-analytics-rviz \
    swri-geometry-util \
    swri-image-util \
    swri-opencv-util \
    swri-route-util \
    swri-transform-util \
    theora-image-transport \
    tts \
    vision-opencv \
"
