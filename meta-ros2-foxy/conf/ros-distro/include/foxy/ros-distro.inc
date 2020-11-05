# foxy/ros-distro.inc
# General configuration settings that are dependent on ROS_DISTRO.
#
# Copyright (c) 2020 LG Electronics, Inc.

ROS_DISTRO_CODENAME = "Foxy Fitzroy"

ROS2_DISTRO = "foxy"

# The platform release that the metadata for this ROS distro targets. This determines the versions of the platform packages that
# OE must provide. It must be one of the values of ROS_DISTRO_RELEASE_PLATFORMS (which is set in
# generated/superflore-ros-distro.inc).
ROS_DISTRO_BASELINE_PLATFORM = "ubuntu-focal"

require conf/ros-distro/include/foxy/generated/superflore-datetime.inc
require conf/ros-distro/include/foxy/generated/superflore-ros-distro.inc
require conf/ros-distro/include/foxy/ros-distro-recipe-blacklist.inc
require conf/ros-distro/include/foxy/ros-distro-preferred-versions.inc
require conf/ros-distro/include/foxy/ros-distro-preferred-providers.inc

# Override settings from generated/superflore-ros-distro.inc here.

# Since superflore doesn't know when it's generating a recipe that it will be for a build tool, it can't know that what's in
# ROS_EXEC_DEPEND are also build tools. Manually add them here.
ROS_SUPERFLORE_GENERATED_BUILDTOOLS += " \
    ament-lint-native \
    domain-coordinator-native \
    foonathan-memory-vendor-native \
    rcpputils-native \
    rmw-dds-common-native \
    rmw-fastrtps-cpp-native \
    rmw-fastrtps-shared-cpp-native \
    rmw-native \
    rosidl-adapter-native \
    rosidl-default-runtime-native \
    rosidl-parser-native \
    rosidl-typesupport-fastrtps-c-native \
    rpyutils-native \
    uncrustify-vendor-native \
"

# this needs google-benchmark-vendor-native but we probably don't need native version
ROS_SUPERFLORE_GENERATED_BUILDTOOLS_remove = "ament-cmake-google-benchmark-native"

# alternative not yet supported implementation for fastrtps
ROS_WORLD_SKIP_GROUPS += "connext"
# alternative not yet supported implementation for fastrtps
ROS_WORLD_SKIP_GROUPS += "opensplice"
# alternative not yet supported implementation for fastrtps, there is no recipe for gurumdds-2.6
ROS_WORLD_SKIP_GROUPS += "gurumdds"
# Can't build these until we figure out how to build clang-format, clang-tidy without building all of clang.
ROS_WORLD_SKIP_GROUPS += "clang"
# recipes depending on turtlebot3 specific recipes which weren't ported to eloquent yet
ROS_WORLD_SKIP_GROUPS += "turtlebot3"
# recipes depending on coinor-libipopt
ROS_WORLD_SKIP_GROUPS += "coinor-libipopt"
# Needs work to launch qemu to run tests on image on build machine.
ROS_WORLD_SKIP_GROUPS += "launch"
# recipes depending on ROS_UNRESOLVED_PLATFORM_PKG_python3-babeltrace which cannot be just
# set to babeltrace, because python bindings in babeltrace are not enabled as shown in log.do_configure:
# configure: You may configure with --enable-python-bindings if you want Python bindings.
ROS_WORLD_SKIP_GROUPS += "babeltrace-python"

# recipes depending on 'x11' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', '', 'x11', d)}"
# recipes depending on 'opengl' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '', 'opengl', d)}"
# recipes depending on 'ffmpeg' which is restricted by 'commercial' LICENSE_FLAG
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains_any('LICENSE_FLAGS_WHITELIST', ['commercial', 'ffmpeg', 'commercial_ffmpeg'], '', 'ffmpeg', d)}"
# recipes depending on 'x264' (ffmpeg does depend on it by default as well) which is restricted by 'commercial' LICENSE_FLAG
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains_any('LICENSE_FLAGS_WHITELIST', ['commercial', 'x264', 'commercial_x264'], '', 'x264', d)}"
# There is recipe for glfw in meta-oe in dunfell, but it still needs x11 in DISTRO_FEATURES
# use that in dunfell and blacklist explicitly in older releases
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', '', 'glfw', d)}"

# webots recipes depending on unavailable python moules like:
# ERROR: Nothing RPROVIDES 'UNRESOLVED-python-transforms3d-pip' (but meta-ros2-foxy/generated-recipes/webots-ros2-desktop/webots-ros2-core_0.0.3-1.bb RDEPENDS on or otherwise requires it)
# ERROR: Nothing RPROVIDES 'UNRESOLVED-urdf2webots-pip' (but meta-ros2-foxy/generated-recipes/webots-ros2-desktop/webots-ros2-importer_0.0.3-1.bb RDEPENDS on or otherwise requires it)
# ERROR: Nothing RPROVIDES 'UNRESOLVED-python3-collada-pip' (but meta-ros2-foxy/generated-recipes/webots-ros2-desktop/webots-ros2-importer_0.0.3-1.bb RDEPENDS on or otherwise requires it)
ROS_WORLD_SKIP_GROUPS += "webots-python-modules"

# recipes depending on gazebo, for which there is no OE recipe
ROS_WORLD_SKIP_GROUPS += "gazebo"

# recipes depending on ros1
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'ros1-layer', '', 'ros1', d)}"

# recipes depending on something from meta-qt5 layer
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', '', 'qt5', d)}"

# recipes depending on libqglviewer (https://packages.debian.org/source/stretch/libqglviewer https://packages.debian.org/stretch/libqglviewer2-qt5)
ROS_WORLD_SKIP_GROUPS += "libqglviewer"

# recipes depending on ignition-* (UNRESOLVED-ignition-math6, UNRESOLVED-ignition-msgs5, UNRESOLVED-ignition-transport8)
ROS_WORLD_SKIP_GROUPS += "ignition"

# recipes depending on pugixml
ROS_WORLD_SKIP_GROUPS += "pugixml"

# Not compatible with newer libftdi included in meta-oe: https://github.com/kobuki-base/kobuki_ftdi/issues/3
ROS_WORLD_SKIP_GROUPS += "kobuki-ftdi"

# do_configure failures
ROS_WORLD_SKIP_GROUPS += " \
    lanelet2-traffic-rules \
"

# do_compile failures
ROS_WORLD_SKIP_GROUPS += " \
    mrpt2 \
    qt-gui-cpp \
    rc-dynamics-api \
"

# recipes depending on something from meta-qt4 layer
# XXX Temp until superflore fixed.
# Must use a _pn- override in this file to override the ROS_BUILD_TYPE of a generated recipe,
# because we need to set this variable before the "inherit" line in the recipe is parsed,
# and having it in a .bbappend sets it too late.
ROS_BUILD_TYPE_pn-fmilibrary-vendor = "ament_cmake"
ROS_BUILD_TYPE_pn-ros-workspace = "ament_cmake"
# was changed from ament_cmake to catkin between eloquent and foxy
ROS_BUILD_TYPE_pn-behaviortree-cpp-v3 = "ament_cmake"
# superflore doesn't resolve the build_type conditions correctly:
# https://github.com/lgsvl/lgsvl_msgs-release/blob/release/foxy/lgsvl_msgs/package.xml#L32
#   <build_type condition="$ROS_VERSION == 1">catkin</build_type>
#   <build_type condition="$ROS_VERSION == 2">ament_cmake</build_type>
ROS_BUILD_TYPE_pn-lgsvl-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-gps-umd = "ament_cmake"
ROS_BUILD_TYPE_pn-plotjuggler = "ament_cmake"
ROS_BUILD_TYPE_pn-kartech-linear-actuator-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-automotive-autonomy-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-automotive-platform-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-automotive-navigation-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-delphi-srr-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-delphi-esr-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-delphi-mrr-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-ibeo-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-mobileye-560-660-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-derived-object-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-astuff-sensor-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-pacmod-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-neobotix-usboard-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-lanelet2-projection = "ament_cmake"
ROS_BUILD_TYPE_pn-lanelet2 = "ament_cmake"
ROS_BUILD_TYPE_pn-lanelet2-maps = "ament_cmake"
ROS_BUILD_TYPE_pn-lanelet2-validation = "ament_cmake"
ROS_BUILD_TYPE_pn-lanelet2-io = "ament_cmake"
ROS_BUILD_TYPE_pn-lanelet2-python = "ament_cmake"
ROS_BUILD_TYPE_pn-lanelet2-traffic-rules = "ament_cmake"
ROS_BUILD_TYPE_pn-lanelet2-core = "ament_cmake"
ROS_BUILD_TYPE_pn-lanelet2-examples = "ament_cmake"
ROS_BUILD_TYPE_pn-lanelet2-routing = "ament_cmake"
ROS_BUILD_TYPE_pn-mrt-cmake-modules = "ament_cmake"

# Used by:
# generated-recipes/spdlog-vendor/spdlog-vendor_1.1.1-1.bb
# generated-recipes/rcl-logging/rcl-logging-spdlog_0.4.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_spdlog = "spdlog"

# Used by:
# generated-recipes/sros2/sros2_0.9.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-cryptography = "python3-cryptography"

# Used by:
# generated-recipes/ament-lint/ament-mypy_0.9.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-mypy = "python3-mypy"

# Used by:
# generated-recipes/ament-lint/ament-pycodestyle_0.9.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-pycodestyle = "python3-pycodestyle"

# Used by:
# /generated-recipes/joystick-drivers/sdl2-vendor_2.4.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_sdl2 = "libsdl2"

# Used by:
# generated-recipes/python-qt-binding/python-qt-binding_1.0.4-1.bb
# generated-recipes/qt-gui-core/qt-gui_1.0.8-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-qt5-bindings = "python3-pyqt5"

# Used by:
# generated-recipes/filters/filters_2.0.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-dev = "boost"

# Used by:
# generated-recipes/cartographer/cartographer_1.0.9001-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-iostreams-dev = "boost"

# Used by:
# generated-recipes/cartographer/cartographer_1.0.9001-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-sphinx = "python3-sphinx"

# Used by:
# generated-recipes/vision-opencv/cv-bridge_2.2.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-python-dev = "boost"

# Used by:
# generated-recipes/vision-opencv/cv-bridge_2.2.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-python = "boost"

# Used by:
# generated-recipes/behaviortree-cpp/behaviortree-cpp-v3_3.5.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libncurses-dev = "ncurses"

# Used by:
# generated-recipes/cyclonedds/cyclonedds_0.5.1-2.bb
ROS_UNRESOLVED_PLATFORM_PKG_maven-native = ""
ROS_UNRESOLVED_PLATFORM_PKG_java-native = ""

# Used by:
# generated-recipes/rosbag2/zstd-vendor_0.2.7-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libzstd-dev = "zstd"

# tango-icon-theme isn't available, but adwaita-icon-theme should be compatible
# Used by:
# generated-recipes/qt-gui-core/qt-gui_1.0.8-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_tango-icon-theme = "adwaita-icon-theme"

# Used by:
# generated-recipes/slam-toolbox/slam-toolbox_2.3.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_tbb = "tbb"

# Used by:
# generated-recipes/octomap/octovis_1.9.5-2.bb
ROS_UNRESOLVED_PLATFORM_PKG_libqt5-opengl-dev = "qtbase"
ROS_UNRESOLVED_PLATFORM_PKG_libqglviewer-dev-qt5 = "qtbase"

# Used by:
# generated-recipes/navigation2/nav2-map-server_0.4.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_graphicsmagick = "graphicsmagick"

# Used by:
# generated-recipes/navigation2/nav2-system-tests_0.4.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_lcov = "lcov"

# Used by:
# generated-recipes/popf/popf_0.0.12-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_bison = "bison"

# Used by:
# generated-recipes/popf/popf_0.0.12-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_flex = "flex"

# Used by:
# generated-recipes/hls-lfcd-lds-driver/hls-lfcd-lds-driver_2.0.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-system-dev = "boost"

# Used by:
# generated-recipes/navigation2/nav2-util_0.4.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-program-options = "boost"

# Used by:
# generated-recipes/ros2cli/ros2doctor_0.9.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-ifcfg = "python3-ifcfg"

# Used by:
# generated-recipes/ros2cli/ros2cli_0.9.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-netifaces = "python3-netifaces"

# python3 bindings are provided by lttng-tools when python PACKAGECONFIG is enabled there
# Used by:
# generated-recipes/ros2-tracing/tracetools-trace_1.0.0-2.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-lttng = "lttng-tools"

# Used by:
# generated-recipes/geographic-info/geodesy_1.0.4-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-pyproj = "python3-pyproj"

# Used by:
# generated-recipes/phidgets-drivers/libphidget22_2.0.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libusb-1.0 = "libusb1"

# Used by:
# generated-recipes/geographic-info/geodesy_1.0.4-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-catkin-pkg = "python3-catkin-pkg"

# Used by:
# generated-recipes/nodl/ros2nodl_0.1.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-argcomplete = "python3-argcomplete"

# Used by:
# generated-recipes/ifm3d-core/ifm3d-core_0.18.0-4.bb
ROS_UNRESOLVED_PLATFORM_PKG_libxmlrpc-c++ = "xmlrpc-c"

# Used by:
# generated-recipes/ament-lint/ament-mypy_0.9.4-1.bb
# generated-recipes/nodl/nodl-python_0.1.0-1.bb
# generated-recipes/nodl/ros2nodl_0.1.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-pytest-mock = "python3-pytest-mock"

# Used by:
# generated-recipes/gps-umd/gpsd-client_1.0.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libgps = "gpsd"

# Used by:
# generated-recipes/marti-common/swri-transform-util_3.2.1-1.bb
# generated-recipes/marti-common/swri-geometry-util_3.2.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libgeos++-dev = "geos"

# Used by:
# generated-recipes/marti-common/swri-transform-util_3.2.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_proj = "proj"

# Used by:
# generated-recipes/mrpt2/mrpt2_2.0.4-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libxxf86vm = "libxxf86vm"

# Used by:
# generated-recipes/rqt-robot-monitor/rqt-robot-monitor_1.0.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-rospkg-modules = "python3-rospkg"

# Used by:
# generated-recipes/py-trees-ros-tutorials/py-trees-ros-tutorials_2.1.0-1.bb
# generated-recipes/py-trees-js/py-trees-js_0.6.3-1.bb
# generated-recipes/py-trees-ros-viewer/py-trees-ros-viewer_0.2.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_pyqt5-dev-tools = "python3-pyqt5"

# Used by:
# generated-recipes/py-trees-ros-tutorials/py-trees-ros-tutorials_2.1.0-1.bb
# generated-recipes/py-trees-js/py-trees-js_0.6.3-1.bb
# generated-recipes/py-trees-ros-viewer/py-trees-ros-viewer_0.2.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_qttools5-dev-tools = "python3-pyqt5"

# Used by:
# generated-recipes/py-trees-js/py-trees-js_0.6.3-1.bb
# generated-recipes/py-trees-ros-viewer/py-trees-ros-viewer_0.2.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-pyqt5.qtwebengine = "python3-pyqt5"

# Used by:
# generated-recipes/dynamic-graph/dynamic-graph_4.2.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_doxygen = "doxygen"

# Used by:
# generated-recipes/mavlink/mavlink_2020.9.10-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-future = "python3-future"

# Used by:
# generated-recipes/kobuki-ftdi/kobuki-ftdi_1.0.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libusb-dev = "libusb1"

# Used by:
# generated-recipes/kobuki-ftdi/kobuki-ftdi_1.0.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_ftdi-eeprom = "libftdi"

# Used by:
# generated-recipes/kobuki-ftdi/kobuki-ftdi_1.0.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libftdi-dev = "libftdi"

# Used by:
# generated-recipes/plotjuggler/plotjuggler_2.8.4-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libqt5multimedia5-plugins = "qtmultimedia"

# Used by:
# generated-recipes/plotjuggler/plotjuggler_2.8.4-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_qtdeclarative5-dev = "qtdeclarative"

# Used by:
# generated-recipes/plotjuggler/plotjuggler_2.8.4-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_binutils = "binutils"

# Used by:
# generated-recipes/plotjuggler/plotjuggler_2.8.4-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libqt5-svg-dev = "qtsvg"

# Used by:
# generated-recipes/plotjuggler/plotjuggler_2.8.4-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_qtmultimedia5-dev = "qtmultimedia"

# Used by:
# generated-recipes/eigenpy/eigenpy_2.5.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3 = "python3"

# Used by:
# generated-recipes/grbl-ros/grbl-ros_0.2.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-serial = "python3-pyserial"

# Used by:
# generated-recipes/rc-genicam-api/rc-genicam-api_2.4.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libpng-dev = "libpng"

# Used by:
# generated-recipes/rc-genicam-api/rc-genicam-api_2.4.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_protobuf = "protobuf"

# Used by:
# generated-recipes/google-benchmark-vendor/google-benchmark-vendor_0.0.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_benchmark = "google-benchmark"

# Used by:
# generated-recipes/mrt-cmake-modules/mrt-cmake-modules_1.0.8-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_lcov = "lcov"
# Needs https://lists.openembedded.org/g/openembedded-devel/message/86162
ROS_UNRESOLVED_PLATFORM_PKG_lcov-native = "lcov-native"
ROS_UNRESOLVED_PLATFORM_PKG_python3-rospkg-native = "python3-rospkg-native"
