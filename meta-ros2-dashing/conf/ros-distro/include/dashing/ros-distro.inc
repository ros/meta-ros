# dashing/ros-distro.inc
# General configuration settings that are dependent on ROS_DISTRO.
#
# Copyright (c) 2019 LG Electronics, Inc.

ROS_DISTRO_CODENAME = "Dashing Diademata"

# The platform release that the metadata for this ROS distro targets. This determines the versions of the platform packages that
# OE must provide. It must be one of the values of ROS_DISTRO_RELEASE_PLATFORMS (which is set in
# generated/superflore-ros-distro.inc).
ROS_DISTRO_BASELINE_PLATFORM = "ubuntu-bionic"

require conf/ros-distro/include/dashing/generated/superflore-datetime.inc
require conf/ros-distro/include/dashing/generated/superflore-ros-distro.inc
require conf/ros-distro/include/dashing/ros-distro-recipe-blacklist.inc
require conf/ros-distro/include/dashing/ros-distro-preferred-versions.inc
require conf/ros-distro/include/dashing/ros-distro-preferred-providers.inc

# alternative not yet supported implementation for fastrtps
ROS_WORLD_SKIP_GROUPS += "connext"
# alternative not yet supported implementation for fastrtps
# https://github.com/ADLINK-IST/opensplice
ROS_WORLD_SKIP_GROUPS += "opensplice"
# Can't build these until we figure out how to build clang-format, clang-tidy without building all of clang.
ROS_WORLD_SKIP_GROUPS += "clang"
# Depends on python3-docker which is available in meta-virtualization, but we don't want to add the
# dependency on this layer to meta-ros yet
ROS_WORLD_SKIP_GROUPS += "docker"
# Needs work to launch qemu to run tests on image on build machine.
ROS_WORLD_SKIP_GROUPS += "launch"
# behaviortree-cpp-v3 and behaviortree-cpp are mutually exclusive because they install files in the same locations. Unlike
# behaviortree-cpp, nothing depends on behaviortree-cpp-v3, so exclude it.
ROS_WORLD_SKIP_GROUPS += "behaviortree-cpp-v3"
# recipes depending on python3-matplotlib
# there is python2 version in meta-ros-common/recipes-devtools/python/python-matplotlib_2.1.1.bb
# but no python3 version yet
ROS_WORLD_SKIP_GROUPS += "python3-matplotlib"
# There is recipe for glfw in meta-oe in dunfell:
# http://cgit.openembedded.org/meta-openembedded/commit/meta-oe/recipes-core/glfw/glfw_3.3.bb?id=a7464eaa69a7ee4734001aab2e232102e7135772
# but we don't have a backports layer from dunfell yet, lets skip it for now
ROS_WORLD_SKIP_GROUPS += "glfw"
# recipes depending on gazebo, for which there is no OE recipe
ROS_WORLD_SKIP_GROUPS += "gazebo"
# recipes depending on gst-python
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'gobject-introspection-data', '', 'gst-python', d)}"

# recipes depending on something from meta-qt5 layer
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', '', 'qt5', d)}"
# recipes depending on something from meta-qt4 layer
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt4-layer', '', 'qt4', d)}"

# recipes depending on 'x11' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', '', 'x11', d)}"
# recipes depending on 'opengl' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '', 'opengl', d)}"
# recipes depending on 'ffmpeg' which is restricted by 'commercial' LICENSE_FLAG
ROS_WORLD_SKIP_GROUPS += "${@ 'ffmpeg' if not d.getVar('LICENSE_FLAGS_WHITELIST') or 'commercial' not in d.getVar('LICENSE_FLAGS_WHITELIST').split() else ''}"

# recipes depending on python*-pyqt5 from meta-qt5 layer
# Use separate group, because e.g. webOS OSE has meta-qt5 layer included, but python*-pyqt5
# is blacklisted, because webOS OSE is missing newer meta-qt5 from warrior with older meta-oe thud which has
# incompatible old sip
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', '', 'pyqt5', d)}"

# if vc4graphics is enabled without opengl in DISTRO_FEATURES then
# gstreamer1.0-plugins-base will be unbuildable for rpi MACHINEs, the
# fix is already included in dunfell and backported to zeus:
# https://github.com/agherzan/meta-raspberrypi/commit/71e188ecd572a00708805989bae71bf4e3ba0f3b
# so this is needed only in warrior (and thud if you enabled vc4graphics
# yourself, because it's included by default only since warrior)
ROS_WORLD_SKIP_GROUPS_append_rpi = "${@ ' vc4graphics-without-opengl' if bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', True, False, d) and not bb.utils.contains('DISTRO_FEATURES', 'opengl', True, False, d) else ''}"

# Override settings from generated/superflore-ros-distro.inc here.

# Since superflore doesn't know when it's generating a recipe that it will be for a build tool, it can't know that what's in
# ROS_EXEC_DEPEND are also build tools. Manually add them here.
ROS_SUPERFLORE_GENERATED_BUILDTOOLS += " \
    ament-lint-native \
    poco-vendor-native \
    rcpputils-native \
    rcutils-native \
    rmw-native \
    rmw-fastrtps-cpp-native \
    rmw-fastrtps-dynamic-cpp-native \
    rmw-fastrtps-shared-cpp-native \
    rmw-implementation-cmake-native \
    rmw-implementation-native \
    rosidl-actions-native \
    rosidl-adapter-native \
    rosidl-typesupport-fastrtps-c-native \
    uncrustify-vendor-native \
"

# Used by generated-recipes/geographic-info/geodesy_1.0.1-1.bb
# use python3 version because python2 is EOL
ROS_UNRESOLVED_PLATFORM_PKG_python-pyproj = "python3-pyproj"

# Used by generated-recipes/phidgets-drivers/libphidget22_2.0.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libusb-1.0 = "libusb1"

# Used by generated-recipes/marti-common/swri-transform-util_3.0.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_proj = "proj"

# Used by generated-recipes/rosbridge-suite/rosbridge-library_1.0.2-1.bb
# and bson is now provided by pymongo
ROS_UNRESOLVED_PLATFORM_PKG_python3-bson = "python3-pymongo"

# Used by generated-recipes/teleop-tools/mouse-teleop_1.0.1-1.bb
# use python3 version because python2 is EOL
ROS_UNRESOLVED_PLATFORM_PKG_python-tk = "python3-tkinter"

# Used by generated-recipes/hls-lfcd-lds-driver/hls-lfcd-lds-driver_2.0.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-system-dev = "boost"

# Used by generated-recipes/navigation2/nav2-util_0.2.6-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-program-options = "boost"

# Used by generated-recipes/marti-common/swri-geometry-util_3.0.3-1.bb
# generated-recipes/marti-common/swri-transform-util_3.0.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libgeos++-dev = "geos"

# Used by generated-recipes/rosbridge-suite/rosbridge-library_1.0.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-pil = "python3-pillow"

# Used by generated-recipes/kinesis-manager/kinesis-manager_2.0.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_log4cplus = "log4cplus"

# Used by generated-recipes/gps-umd/gpsd-client_1.0.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libgps = "gpsd"

# Used by generated-recipes/navigation2/nav2-map-server_0.2.6-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_graphicsmagick = "graphicsmagick"

# Used by generated-recipes/navigation2/nav2-system-tests_0.2.6-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_lcov = "lcov"

# Used by generated-recipes/rosbridge-suite/rosbridge-server_1.0.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-twisted = "python3-twisted"

# Used by generated-recipes/rosbridge-suite/rosbridge-server_1.0.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-tornado = "python3-tornado"

# Used by generated-recipes/tts/tts_2.0.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-plugins-good = "gstreamer1.0-plugins-good"
ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0 = "gstreamer1.0"
ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-alsa = "gstreamer1.0-plugins-base"
ROS_UNRESOLVED_PLATFORM_PKG_python-gst-1.0 = "gstreamer1.0-python"
ROS_UNRESOLVED_PLATFORM_PKG_python3-boto3 = "python3-boto3"

# Used by:
# generated-recipes/py-trees-ros-tutorials/py-trees-ros-tutorials_1.0.5-1.bb
# generated-recipes/py-trees-js/py-trees-js_0.5.0-1.bb
# generated-recipes/py-trees-ros-viewer/py-trees-ros-viewer_0.1.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_pyqt5-dev-tools = "python3-pyqt5"

# Used by:
# generated-recipes/py-trees-ros-tutorials/py-trees-ros-tutorials_1.0.5-1.bb
# generated-recipes/py-trees-js/py-trees-js_0.5.0-1.bb
# generated-recipes/py-trees-ros-viewer/py-trees-ros-viewer_0.1.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_qttools5-dev-tools = "python3-pyqt5"

# Used by:
# generated-recipes/py-trees-ros-tutorials/py-trees-ros-tutorials_1.0.5-1.bb
# generated-recipes/py-trees-js/py-trees-js_0.5.0-1.bb
# generated-recipes/py-trees-ros-viewer/py-trees-ros-viewer_0.1.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-qt5-bindings = "python3-pyqt5"

# Used by:
# generated-recipes/py-trees-js/py-trees-js_0.5.0-1.bb
# generated-recipes/py-trees-ros-viewer/py-trees-ros-viewer_0.1.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-pyqt5.qtwebengine = "python3-pyqt5"

# tango-icon-theme isn't available, but adwaita-icon-theme should be compatible
# Used by:
# generated-recipes/qt-gui-core/qt-gui_1.0.7-1.bbb
ROS_UNRESOLVED_PLATFORM_PKG_tango-icon-theme = "adwaita-icon-theme"

# Used by:
# generated-recipes/slam-toolbox/slam-toolbox_2.0.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_tbb = "tbb"

# Used by:
# generated-recipes/rqt-tf-tree/rqt-tf-tree_1.0.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-rospkg = "python3-rospkg"

# XXX Temp until superflore fixed.
# Must use a _pn- override in this file to override the ROS_BUILD_TYPE of a generated recipe,
# because we need to set this variable before the "inherit" line in the recipe is parsed,
# and having it in a .bbappend sets it too late.
ROS_BUILD_TYPE_pn-async-web-server-cpp = "ament_cmake"
ROS_BUILD_TYPE_pn-astuff-sensor-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-automotive-autonomy-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-automotive-navigation-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-automotive-platform-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-delphi-esr-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-delphi-mrr-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-delphi-srr-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-derived-object-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-fmilibrary-vendor = "ament_cmake"
ROS_BUILD_TYPE_pn-geographic-info = "ament_cmake"
ROS_BUILD_TYPE_pn-gps-umd = "ament_cmake"
ROS_BUILD_TYPE_pn-ibeo-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-kartech-linear-actuator-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-ml-classifiers = "ament_cmake"
ROS_BUILD_TYPE_pn-mobileye-560-660-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-neobotix-usboard-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-pacmod-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-radar-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-ros-workspace = "ament_cmake"
ROS_BUILD_TYPE_pn-sros2-cmake = "ament_cmake"
ROS_BUILD_TYPE_pn-web-video-server = "ament_cmake"
