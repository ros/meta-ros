# Copyright (c) 2019-2020 LG Electronics, Inc.

DESCRIPTION = "All non-test packages for the target from files/dashing/cache.yaml"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_dashing

PACKAGES = "${PN}"

RDEPENDS_${PN} = "${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES}"

# "rmw-fastrtps-dynamic-cpp" is mentioned in http://www.ros.org/reps/rep-2000.html, so make sure we always build it (it appears in
# ROS_SUPERFLORE_GENERATED_TESTS, so it's not been added to ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES).
RDEPENDS_${PN}_append = " rmw-fastrtps-dynamic-cpp"

# Remove these explicitly until they are dropped from the ROS_EXEC_DEPENDS of ros-core, after which (most of them) will not be in
# in ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES because they only appear in ROS_TEST_DEPENDS.
RDEPENDS_${PN}_remove = "ament-cmake"
RDEPENDS_${PN}_remove = "ament-cmake-auto"
RDEPENDS_${PN}_remove = "ament-cmake-gmock"
RDEPENDS_${PN}_remove = "ament-cmake-gtest"
RDEPENDS_${PN}_remove = "ament-cmake-pytest"
RDEPENDS_${PN}_remove = "ament-cmake-ros"
RDEPENDS_${PN}_remove = "ament-index-cpp"
RDEPENDS_${PN}_remove = "ament-index-python"
RDEPENDS_${PN}_remove = "ament-lint-auto"
RDEPENDS_${PN}_remove = "ament-lint-common"
RDEPENDS_${PN}_remove = "rosidl-default-generators"

# Can't build these until we figure out how to build clang-format without building all of clang.
RDEPENDS_${PN}_remove = "ament-clang-format"
RDEPENDS_${PN}_remove = "ament-clang-tidy"
RDEPENDS_${PN}_remove = "ament-cmake-clang-format"
RDEPENDS_${PN}_remove = "ament-cmake-clang-tidy"

# Not used by "dashing"; this allows us to defer fixing log4cxx v0.10.0-13 until working on "melodic".
RDEPENDS_${PN}_remove = "rcl-logging-log4cxx"

# Needs work to launch qemu to run tests on image on build machine.
RDEPENDS_${PN}_remove = "launch-testing"
RDEPENDS_${PN}_remove = "launch-testing-ament-cmake"
RDEPENDS_${PN}_remove = "launch-testing-ros"
RDEPENDS_${PN}_remove = "ros-testing"

# Depends on python3-docker which is available in meta-virtualization, but we don't want to add the
# dependency on this layer to meta-ros yet
RDEPENDS_${PN}_remove = "cross-compile"
RDEPENDS_${PN}_remove = "launch-ros-sandbox"

# sophus package is empty, so not created, crystal and melodic have bbappend to create empty package
# but that is quite useless, either we should fix the packaging to have something useful in PN
# or not to install completely empty package like here
RDEPENDS_${PN}_remove = "sophus"

# | CMake Error at .../cartographer/1.0.0-1-r0/recipe-sysroot/usr/lib/cmake/Ceres/CeresConfig.cmake:88 (message):
# |   Failed to find Ceres - Missing requested Ceres components: [SuiteSparse]
# |   (components requested: [SuiteSparse]).  Detected Ceres version: 1.14.0
# |   installed in:
# |   .../cartographer/1.0.0-1-r0/recipe-sysroot/usr
# |   with components: [EigenSparse, SparseLinearAlgebraLibrary,
# |   SchurSpecializations, OpenMP, Multithreading].
RDEPENDS_${PN}_remove = "cartographer"

# do_compile() failed to build .a:
# NOTE: VERBOSE=1 cmake --build .../fmi-adapter/0.1.4-1-r0/build --target all -- -j 24
# ninja: error: 'FMILibraryProject-prefix/src/install/lib/libfmilib.a', needed by 'libfmi_adapter.so', missing and no known rule to make it
# WARNING: exit code 1 from a shell command.
# ERROR: Function failed: do_compile
RDEPENDS_${PN}_remove = "fmi-adapter"
RDEPENDS_${PN}_remove = "fmi-adapter-examples"

# Call of overloaded function is ambiguous:
# | from .../teleop_twist_joy-release-release-dashing-teleop_twist_joy-2.2.0-1/src/teleop_twist_joy.cpp:28:
# | .../recipe-sysroot/usr/include/rclcpp/node_impl.hpp: In instantiation of 'auto rclcpp::Node::declare_parameter(const string&, const ParameterT&, const ParameterDescriptor&) [with ParameterT = long int; std::__cxx11::string = std::__cxx11::basic_string<char>; rcl_interfaces::msg::ParameterDescriptor = rcl_interfaces::msg::ParameterDescriptor_<std::allocator<void> >]':
# | .../teleop_twist_joy-release-release-dashing-teleop_twist_joy-2.2.0-1/src/teleop_twist_joy.cpp:78:70:   required from here
# | .../recipe-sysroot/usr/include/rclcpp/node_impl.hpp:257:13: error: call of overloaded 'ParameterValue(const long int&)' is ambiguous
# |      rclcpp::ParameterValue(default_value),
# |              ^~~~~~~~~~~~~~~~~~~~~~~~~~~~~
RDEPENDS_${PN}_remove = "teleop-twist-joy"

# Contains only dev, dbg and staticdev files, so PN is empty and not created
RDEPENDS_${PN}_remove = "cloudwatch-metrics-common"

# Contains only dev, dbg and staticdev files, so PN is empty and not created
RDEPENDS_${PN}_remove = "lex-common"

# Depends on Qt4 (libqt4-dev libqt4-opengl-dev libqglviewer-qt4-dev) which we don't plan to support
RDEPENDS_${PN}_remove = "octovis"

# OE won't let us build ffmpeg unless LICENSE_FLAGS_WHITELIST contains "commerical". These packages depend on it:
RDEPENDS_${PN}_remove = "${@bb.utils.contains('LICENSE_FLAGS_WHITELIST', 'commercial', '', 'web-video-server', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('LICENSE_FLAGS_WHITELIST', 'commercial', '', 'h264-encoder-core', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('LICENSE_FLAGS_WHITELIST', 'commercial', '', 'h264-video-encoder', d)}"

# behaviortree-cpp-v3 and behaviortree-cpp are mutually exclusive because they install files in the same locations. Unlike
# behaviortree-cpp, nothing depends on behaviortree-cpp-v3, so exclude it.
RDEPENDS_${PN}_remove = "behaviortree-cpp-v3"

# Depends on gstreamer1.0-python which requires gobject-introspection-data in DISTRO_FEATURES
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'gobject-introspection-data', '', 'tts', d)}"

# desktop RDEPENDS on rviz packages.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-desktop ros-rviz', '', 'desktop', d)}"

# NB. gazebo-msgs is a dependency of non-Gazebo packages, so it doesn't appear here.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-gazebo', '', 'gazebo-rosdev', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-gazebo', '', 'gazebo-plugins', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-gazebo', '', 'gazebo-ros', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-gazebo', '', 'gazebo-ros-pkgs', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-gazebo', '', 'nav2-system-tests', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-gazebo', '', 'turtlebot3-gazebo', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-gazebo', '', 'turtlebot3-simulations', d)}"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-realsense', '', 'librealsense2', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-realsense', '', 'realsense-camera-msgs', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-realsense', '', 'realsense-ros2-camera', d)}"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-qt5', '', 'python-qt-binding', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-qt5', '', 'qt-dotgraph', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-qt5', '', 'qt-gui', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-qt5', '', 'qt-gui-app', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-qt5', '', 'qt-gui-core', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-qt5', '', 'qt-gui-cpp', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-qt5', '', 'qt-gui-py-common', d)}"
# Depends on pyqt5-dev-tools
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-qt5', '', 'py-trees-ros-tutorials', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-qt5', '', 'py-trees-js', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-qt5', '', 'py-trees-ros-viewer', d)}"
# Depends on qtbase
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-qt5', '', 'turtlesim', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-qt5', '', 'nav2-rviz-plugins', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-qt5', '', 'slam-toolbox', d)}"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-action', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-console', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-common-plugins', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-graph', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-gui', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-gui-cpp', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-gui-py', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-image-view', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-msg', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-plot', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-publisher', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-py-common', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-py-console', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-reconfigure', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-robot-steering', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-service-caller', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-shell', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-srv', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-top', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-topic', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-tf-tree', d)}"


# RViz requires the "opengl" distro feature.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'object-analytics-rviz', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz-assimp-vendor', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz-common', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz-default-plugins', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz-ogre-vendor', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz-rendering', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz-rendering-tests', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz-visual-testing-framework', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz2', d)}"
