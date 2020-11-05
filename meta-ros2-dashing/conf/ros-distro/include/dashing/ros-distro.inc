# dashing/ros-distro.inc
# General configuration settings that are dependent on ROS_DISTRO.
#
# Copyright (c) 2019-2020 LG Electronics, Inc.

ROS_DISTRO_CODENAME = "Dashing Diademata"

ROS2_DISTRO = "dashing"

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
# alternative not yet supported implementation for fastrtps, there is no recipe for gurumdds-2.6
ROS_WORLD_SKIP_GROUPS += "gurumdds"
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
# recipes depending on pugixml
ROS_WORLD_SKIP_GROUPS += "pugixml"

# recipes depending on something from meta-qt5 layer
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', '', 'qt5', d)}"
# recipes depending on something from meta-qt4 layer
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt4-layer', '', 'qt4', d)}"

# recipes depending on 'x11' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', '', 'x11', d)}"
# recipes depending on 'opengl' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '', 'opengl', d)}"
# recipes depending on 'ffmpeg' which is restricted by 'commercial' LICENSE_FLAG
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains_any('LICENSE_FLAGS_WHITELIST', ['commercial', 'ffmpeg', 'commercial_ffmpeg'], '', 'ffmpeg', d)}"
# recipes depending on 'x264' (ffmpeg does depend on it by default as well) which is restricted by 'commercial' LICENSE_FLAG
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains_any('LICENSE_FLAGS_WHITELIST', ['commercial', 'x264', 'commercial_x264'], '', 'x264', d)}"

# recipes depending on python*-pyqt5 from meta-qt5 layer
# Use separate group, because e.g. webOS OSE has meta-qt5 layer included, but python*-pyqt5
# is blacklisted, because webOS OSE is missing newer meta-qt5 from warrior with older meta-oe thud which has
# incompatible old sip
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', '', 'pyqt5', d)}"

# do_configure failures
ROS_WORLD_SKIP_GROUPS += " \
    lanelet2-traffic-rules \
"

# do_compile failures
ROS_WORLD_SKIP_GROUPS += " \
    rc-dynamics-api \
"

# Override settings from generated/superflore-ros-distro.inc here.

# Since superflore doesn't know when it's generating a recipe that it will be for a build tool, it can't know that what's in
# ROS_EXEC_DEPEND are also build tools. Manually add them here.
ROS_SUPERFLORE_GENERATED_BUILDTOOLS += " \
    ament-lint-native \
    builtin-interfaces-native \
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
    rosidl-default-runtime-native \
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
# Used by generated-recipes/transport-drivers/udp-driver_0.0.5-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-system = "boost"

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

# Used by generated-recipes/ament-virtualenv/ament-virtualenv_0.0.5-5.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-packaging = "python3-packaging"
ROS_UNRESOLVED_PLATFORM_PKG_python3-packaging-native = "python3-packaging-native"
ROS_UNRESOLVED_PLATFORM_PKG_python-virtualenv = "python3-virtualenv"
ROS_UNRESOLVED_PLATFORM_PKG_python-virtualenv-native = "python3-virtualenv-native"

# Used by:
# generated-recipes/mapviz/tile-map_2.0.0-1.bb
# generated-recipes/mapviz/mapviz_2.0.0-1.bb
# generated-recipes/swri-console/swri-console_2.0.0-1.bb
# generated-recipes/mapviz/multires-image_2.0.0-1.bb
# generated-recipes/mapviz/mapviz-plugins_2.0.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libqt5-opengl-dev = "qtbase"

# Used by:
# generated-recipes/mapviz/mapviz_2.0.0-1.bb
# generated-recipes/mapviz/tile-map_2.0.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libglew-dev = "glew"

# Used by:
# generated-recipes/mapviz/mapviz_2.0.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libxmu-dev = "libxmu"

# Used by:
# generated-recipes/mapviz/mapviz_2.0.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libxi-dev = "libxi"

# Used by:
# generated-recipes/mapviz/tile-map_2.0.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libjsoncpp = "jsoncpp"
ROS_UNRESOLVED_PLATFORM_PKG_libjsoncpp-dev = "jsoncpp"

# Used by:
# generated-recipes/ifm3d-core/ifm3d-core_0.17.0-12.bb
ROS_UNRESOLVED_PLATFORM_PKG_libxmlrpc-c++ = "xmlrpc-c"

# Used by:
# generated-recipes/rc-genicam-api/rc-genicam-api_2.3.5-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libpng-dev = "libpng"

# Used by:
# generated-recipes/marti-common/swri-transform-util_3.2.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_tf2_py = ""

# Used by:
# generated-recipes/marti-common/swri-transform-util_3.2.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_launch_xml = ""

# Used by:
# generated-recipes/rc-dynamics-api/rc-dynamics-api_0.10.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_protobuf = "protobuf"

# Used by:
# enerated-recipes/cartographer/cartographer_1.0.9001-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-iostreams-dev = "boost"

# Used by:
# generated-recipes/cartographer/cartographer_1.0.9001-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-sphinx = "python3-sphinx"

# Used by:
# generated-recipes/mrt-cmake-modules/mrt-cmake-modules_1.0.8-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_lcov = "lcov"
# Needs https://lists.openembedded.org/g/openembedded-devel/message/86162
ROS_UNRESOLVED_PLATFORM_PKG_lcov-native = "lcov-native"
ROS_UNRESOLVED_PLATFORM_PKG_python3-rospkg-native = "python3-rospkg-native"

# Used by:
# generated-recipes/grbl-ros/grbl-ros_0.0.15-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-serial = "python3-pyserial"

# Used by:
# generated-recipes/lanelet2/lanelet2-python_1.1.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-python-dev = "boost"

# Used by:
# generated-recipes/image-pipeline/image-view_2.1.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-dev = "boost"

# XXX Temp until superflore fixed.
# Must use a _pn- override in this file to override the ROS_BUILD_TYPE of a generated recipe,
# because we need to set this variable before the "inherit" line in the recipe is parsed,
# and having it in a .bbappend sets it too late.
ROS_BUILD_TYPE_pn-async-web-server-cpp = "ament_cmake"
ROS_BUILD_TYPE_pn-astuff-sensor-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-automotive-autonomy-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-automotive-navigation-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-automotive-platform-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-behaviortree-cpp-v3 = "ament_cmake"
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
# superflore doesn't resolve the build_type conditions correctly:
# https://github.com/lgsvl/lgsvl_msgs-release/blob/release/foxy/lgsvl_msgs/package.xml#L32
#   <build_type condition="$ROS_VERSION == 1">catkin</build_type>
#   <build_type condition="$ROS_VERSION == 2">ament_cmake</build_type>
ROS_BUILD_TYPE_pn-lgsvl-msgs = "ament_cmake"

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
