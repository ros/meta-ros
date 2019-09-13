# packagegroup-ros-world-crystal.inc
#
# Copyright (c) 2019 LG Electronics, Inc.

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
RDEPENDS_${PN}_remove = "ament-cmake-clang-format"

# Not used by "crystal"; this allows us to defer fixing log4cxx v0.10.0-13 until working on "melodic".
RDEPENDS_${PN}_remove = "rcl-logging-log4cxx"

# | CMake Error at .../cartographer/1.0.0-1-r0/recipe-sysroot/usr/lib/cmake/Ceres/CeresConfig.cmake:88 (message):
# |   Failed to find Ceres - Missing requested Ceres components: [SuiteSparse]
# |   (components requested: [SuiteSparse]).  Detected Ceres version: 1.14.0
# |   installed in:
# |   .../cartographer/1.0.0-1-r0/recipe-sysroot/usr
# |   with components: [EigenSparse, SparseLinearAlgebraLibrary,
# |   SchurSpecializations, OpenMP, Multithreading].
RDEPENDS_${PN}_remove = "cartographer"

# do_configure() failed:
# Log data follows:
# DEBUG: Executing shell function do_configure
# Traceback (most recent call last):
#   File "setup.py", line 7, in <module>
#     package = ElementTree.parse(here / 'package.xml')
#   File "/mnt/disk2/YOCTO-ARTIFACTS/BUILD-1/tmp-glibc/work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/keystroke/0.3.0-1-r0/recipe-sysroot-native/usr/lib/python3.5/xml/etree/ElementTree.py", line 1195, in parse
#     tree.parse(source, parser)
#   File "/mnt/disk2/YOCTO-ARTIFACTS/BUILD-1/tmp-glibc/work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/keystroke/0.3.0-1-r0/recipe-sysroot-native/usr/lib/python3.5/xml/etree/ElementTree.py", line 585, in parse
#     source = open(source, "rb")
# TypeError: invalid file: PosixPath('package.xml')
# WARNING: exit code 1 from a shell command.
RDEPENDS_${PN}_remove = "keystroke"

# do_compile() failed to build .a:
# NOTE: VERBOSE=1 cmake --build .../fmi-adapter/0.1.4-1-r0/build --target all -- -j 24
# ninja: error: 'FMILibraryProject-prefix/src/install/lib/libfmilib.a', needed by 'libfmi_adapter.so', missing and no known rule to make it
# WARNING: exit code 1 from a shell command.
# ERROR: Function failed: do_compile
RDEPENDS_${PN}_remove = "fmi-adapter"
RDEPENDS_${PN}_remove = "fmi-adapter-examples"

# Only builds for Intel achitectures; could build for emulator, but don't because its rootfs contents should be kept the same as
# that of the actual device.
RDEPENDS_${PN}_remove = "ets-plugin"

# OE won't let us build ffmpeg unless LICENSE_FLAGS_WHITELIST contains "commerical".
RDEPENDS_${PN}_remove = "${@bb.utils.contains('LICENSE_FLAGS_WHITELIST', 'commercial', '', 'ffmpeg', d)}"

# behaviortree-cpp-v3 and behaviortree-cpp are mutually exclusive because they install files in the same locations. Unlike
# behaviortree-cpp, nothing depends on behaviortree-cpp-v3, so exclude it.
RDEPENDS_${PN}_remove = "behaviortree-cpp-v3"

# desktop RDEPENDS on rviz packages.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-desktop ros-rviz', '', 'desktop', d)}"

# NB. gazebo-msgs is a dependency of non-Gazebo packages, so it doesn't appear here.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-gazebo', '', 'gazebo-rosdev', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-gazebo', '', 'gazebo-plugins', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-gazebo', '', 'gazebo-ros', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-gazebo', '', 'gazebo-ros-pkgs', d)}"

# MRPT requires the "opengl" distro feature.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-mrpt opengl', '', 'mrpt2', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-mrpt opengl', '', 'wxpython', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-mrpt opengl', '', 'wxwidgets', d)}"

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

RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-action', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-console', d)}"
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
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-service-caller', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-shell', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-srv', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-top', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-topic', d)}"

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
