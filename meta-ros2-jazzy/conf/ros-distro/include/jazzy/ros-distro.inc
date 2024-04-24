# jazzy/ros-distro.inc
# General configuration settings that are dependent on ROS_DISTRO.
#
# Copyright (c) 2020-2021 LG Electronics, Inc.

ROS_DISTRO_CODENAME = "Jazzy Jalisco"

ROS2_DISTRO = "jazzy"

# The platform release that the metadata for this ROS distro targets. This determines the versions of the platform packages that
# OE must provide. It must be one of the values of ROS_DISTRO_RELEASE_PLATFORMS (which is set in
# generated/superflore-ros-distro.inc).
ROS_DISTRO_BASELINE_PLATFORM = "ubuntu-noble"

require conf/ros-distro/include/jazzy/generated/superflore-datetime.inc
require conf/ros-distro/include/jazzy/generated/superflore-ros-distro.inc
require conf/ros-distro/include/jazzy/ros-distro-recipe-blacklist.inc
require conf/ros-distro/include/jazzy/ros-distro-preferred-versions.inc
require conf/ros-distro/include/jazzy/ros-distro-preferred-providers.inc

# Override settings from generated/superflore-ros-distro.inc here.

# Since superflore doesn't know when it's generating a recipe that it will be for a build tool, it can't know that what's in
# ROS_EXEC_DEPEND are also build tools. Manually add them here.
ROS_SUPERFLORE_GENERATED_BUILDTOOLS += " \
    action-msgs-native \
    ament-acceleration-native \
    ament-lint-native \
    ament-cmake-cpplint-native \
    ament-cmake-uncrustify-native \
    composition-interfaces-native \
    cyclonedds-native \
    domain-coordinator-native \
    fastcdr-native \
    fastrtps-native \
    foonathan-memory-vendor-native \
    generate-parameter-library-py-native \
    iceoryx-binding-c-native \
    iceoryx-hoofs-native \
    iceoryx-posh-native \
    launch-native \
    launch-ros-native \
    launch-yaml-native \
    launch-xml-native \
    launch-testing-ros-native \
    libyaml-vendor-native \
    lifecycle-msgs-native \
    osrf-pycommon-native \
    pybind11-vendor-native \
    rcutils-native \
    rcl-action-native \
    rcl-interfaces-native \
    rcl-lifecycle-native \
    rcl-logging-interface-native \
    rcl-logging-spdlog-native \
    rcl-native \
    rcl-yaml-param-parser-native \
    rclpy-native \
    rcpputils-native \
    rmf-building-map-msgs-native \
    rmf-site-map-msgs-native \
    rmw-cyclonedds-cpp-native \
    rmw-dds-common-native \
    rmw-fastrtps-cpp-native \
    rmw-fastrtps-dynamic-cpp-native \
    rmw-fastrtps-shared-cpp-native \
    rmw-implementation-native \
    rmw-native \
    ros2cli-native \
    ros2pkg-native \
    rosgraph-msgs-native \
    rosidl-adapter-native \
    rosidl-cli-native \
    rosidl-core-runtime-native \
    rosidl-default-runtime-native \
    rosidl-dynamic-typesupport-native \
    rosidl-generator-type-description-native \
    rosidl-parser-native \
    rosidl-runtime-c-native \
    rosidl-runtime-cpp-native \
    rosidl-typesupport-c-native \
    rosidl-typesupport-cpp-native \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-runtime-c-native \
    rosidl-runtime-cpp-native \
    rpyutils-native \
    spdlog-vendor-native \
    std-msgs-native \
    tracetools-native \
    uncrustify-vendor-native \
    unique-identifier-msgs-native \
"

# this needs google-benchmark-vendor-native but we probably don't need native version
ROS_SUPERFLORE_GENERATED_BUILDTOOLS:remove = "ament-cmake-google-benchmark-native"

# alternative not yet supported implementation for fastrtps
ROS_WORLD_SKIP_GROUPS += "connext"
# alternative not yet supported implementation for fastrtps
ROS_WORLD_SKIP_GROUPS += "opensplice"
# alternative not yet supported implementation for fastrtps, there is no recipe for gurumdds-2.6
ROS_WORLD_SKIP_GROUPS += "gurumdds"
# recipes depending on turtlebot3 specific recipes which weren't ported to eloquent yet
ROS_WORLD_SKIP_GROUPS += "turtlebot3"
# recipes depending on coinor-libipopt
ROS_WORLD_SKIP_GROUPS += "coinor-libipopt"
# Needs work to launch qemu to run tests on image on build machine.
ROS_WORLD_SKIP_GROUPS += "launch"
# recipes depending on ROS_UNRESOLVED_DEP-python3-babeltrace which cannot be just
# set to babeltrace, because python bindings in babeltrace are not enabled as shown in log.do_configure:
# configure: You may configure with --enable-python-bindings if you want Python bindings.
ROS_WORLD_SKIP_GROUPS += "babeltrace-python"
# recipes depends on cwiid
ROS_WORLD_SKIP_GROUPS += "cwiid"
# recipes depends on libspnav
ROS_WORLD_SKIP_GROUPS += "libspnav"
# recipes depends on libopen3d
ROS_WORLD_SKIP_GROUPS += "libopen3d"
# recipes depends on aws
ROS_WORLD_SKIP_GROUPS += "aws"
# recipes depends on mrpt2
ROS_WORLD_SKIP_GROUPS += "mrpt2"

# recipes depending on 'x11' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', '', 'x11', d)}"
# recipes depending on 'opengl' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '', 'opengl', d)}"
# recipes depending on 'ffmpeg' which is restricted by 'commercial' LICENSE_FLAG
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains_any('LICENSE_FLAGS_ACCEPTED', ['commercial', 'ffmpeg', 'commercial_ffmpeg'], '', 'ffmpeg', d)}"
# recipes depending on 'x264' (ffmpeg does depend on it by default as well) which is restricted by 'commercial' LICENSE_FLAG
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains_any('LICENSE_FLAGS_ACCEPTED', ['commercial', 'x264', 'commercial_x264'], '', 'x264', d)}"
# There is recipe for glfw in meta-oe in dunfell, but it still needs x11 in DISTRO_FEATURES
# use that in dunfell and blacklist explicitly in older releases
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', '', 'glfw', d)}"

# webots recipes depending on unavailable python moules like:
# ERROR: Nothing RPROVIDES 'ROS_UNRESOLVED_DEP-python-transforms3d-pip' (but meta-ros2-rolling/generated-recipes/webots-ros2-desktop/webots-ros2-core_0.0.3-1.bb RDEPENDS on or otherwise requires it)
# ERROR: Nothing RPROVIDES 'ROS_UNRESOLVED_DEP-urdf2webots-pip' (but meta-ros2-rolling/generated-recipes/webots-ros2-desktop/webots-ros2-importer_0.0.3-1.bb RDEPENDS on or otherwise requires it)
# ERROR: Nothing RPROVIDES 'ROS_UNRESOLVED_DEP-python3-collada-pip' (but meta-ros2-rolling/generated-recipes/webots-ros2-desktop/webots-ros2-importer_0.0.3-1.bb RDEPENDS on or otherwise requires it)
ROS_WORLD_SKIP_GROUPS += "webots-python-modules"

# recipes depending on gazebo-rosdev
ROS_WORLD_SKIP_GROUPS += "gazebo"

# recipes depending on libqglviewer (https://packages.debian.org/source/stretch/libqglviewer https://packages.debian.org/stretch/libqglviewer2-qt5)
ROS_WORLD_SKIP_GROUPS += "libqglviewer"

# recipes depending on ignition-* (ROS_UNRESOLVED_DEP-ignition-gazebo5, ROS_UNRESOLVED_DEP-ignition-math6, ROS_UNRESOLVED_DEP-ignition-msgs7, ROS_UNRESOLVED_DEP-ignition-transport10, ROS_UNRESOLVED_DEP-ignition-rendering5, ROS_UNRESOLVED_DEP-ignition-common4, ROS_UNRESOLVED_DEP-ignition-gui5)
ROS_WORLD_SKIP_GROUPS += "ignition"

# recipes depending on legacy mongo-cxx-driver (https://packages.debian.org/source/stretch/mongo-cxx-driver-legacy)
# the mongodb recipe in meta-oe installs just the binaries mongoc, mongos, install_compass
# the header files searched by mongo-store, warehouse-ros-mongo cmake files cmake/FindMongoClient.cmake and cmake/FindMongoDB.cmake
# aren't even part of current version of mongo-cxx-driver
# src/mongo/client/dbclient.h and src/mongo/client/dbclientinterface.h are only in the legacy branches
ROS_WORLD_SKIP_GROUPS += "mongodb-legacy-cxx-driver"

# recipes depending on ros1
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'ros1-layer', '', 'ros1', d)}"

# recipes depending on something from meta-qt5 layer
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', '', 'qt5', d)}"

# recipes depending on libomp which could be provided by openmp@meta-clang
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'clang-layer', '', 'libomp', d)}"

# recipes depending on clang which could be provided by clang@meta-clang
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'clang-layer', '', 'clang', d)}"

# recipes depending on cargo which could be provided by cargo@meta-rust or oe-core[honister] and newer release (where it was imported from meta-rust)
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'rust-layer', '', 'cargo', d)}"

# recipes depending on scipy which could be provided by python3-scipy@meta-scipy
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'meta-scipy', '', 'scipy', d)}"

# swri recipes depending on marti-*-msgs, currently broken after to https://github.com/ros/rosdistro/commit/e019cc8729e7ff2ba2ed51e63886734936254111
ROS_WORLD_SKIP_GROUPS += "swri"

# packages (like depthai) that use hunter
ROS_WORLD_SKIP_GROUPS += "hunter"

# packages (like tracetools-analysis) that use jupyter
ROS_WORLD_SKIP_GROUPS += "jupyter"

# packages (like open3d-conversion) that use libopen3d
ROS_WORLD_SKIP_GROUPS += "libopen3d"

# packages (like fogros2) that use wireguard
ROS_WORLD_SKIP_GROUPS += "wireguard"

# packages (like rtabmap) that use g2o
ROS_WORLD_SKIP_GROUPS += "g2o"

# Must use a _pn- override in this file to override the ROS_BUILD_TYPE of a generated recipe,
# because we need to set this variable before the "inherit" line in the recipe is parsed,
# and having it in a .bbappend sets it too late.
# We want ament_cmake instead of plain cmake for ros-workspace:
# https://raw.github.com/ros2-gbp/ros_workspace-release/release/rolling/ros_workspace/1.0.1-2/package.xml
ROS_BUILD_TYPE:pn-ros-workspace = "ament_cmake"
# And also for rmf-task, otherwise many dependencies won't be detected
ROS_BUILD_TYPE:pn-rmf-task = "ament_cmake"

# Used by generated-recipes/cyclonedds/cyclonedds_0.6.0-3.bb
ROS_UNRESOLVED_DEP-java-native = ""
ROS_UNRESOLVED_DEP-maven-native = ""

# https://layers.openembedded.org/layerindex/recipe/45261/
ROS_UNRESOLVED_DEP-sqlite3 = "sqlite3"

# Used by generated-recipes/ros2-tracing/tracetools_7.1.0-1.bb
ROS_UNRESOLVED_DEP-lttng-tools = "lttng-tools"

# Used by generated-recipes/libyaml-vendor/libyaml-vendor_1.6.2-1.bb
ROS_UNRESOLVED_DEP-libyaml = "libyaml"
ROS_UNRESOLVED_DEP-libyaml-dev = "libyaml"

# Used by generated-recipes/ament-cmake/ament-cmake-vendor-package_2.3.0-1.bb
ROS_UNRESOLVED_DEP-python3-vcstool-native = "python3-vcstools-native"

# Used by generated-recipes/ament-lint/ament-flake8_0.16.0-1.bb
ROS_UNRESOLVED_DEP-python3-flake8-import-order = "python3-flake8-import-order"

# Used by generated-recipes/ament-lint/ament-flake8_0.16.0-1.bb
ROS_UNRESOLVED_DEP-python3-flake8-builtins = "python3-flake8-builtins"

# Used by generated-recipes/ament-lint/ament-flake8_0.16.0-1.bb
ROS_UNRESOLVED_DEP-python3-flake8-comprehensions = "python3-flake8-comprehensions"

# Used by generated-recipes/ament-lint/ament-flake8_0.16.0-1.bb
ROS_UNRESOLVED_DEP-python3-flake8-docstrings = "python3-flake8-docstrings"

# Used by generated-recipes/ament-lint/ament-flake8_0.16.0-1.bb
ROS_UNRESOLVED_DEP-python3-flake8-quotes = "python3-flake8-quotes"

ROS_UNRESOLVED_DEP-meson-native = "meson-native"
ROS_UNRESOLVED_DEP-python3-ply = "python3-ply"
ROS_UNRESOLVED_DEP-python3-jinja2 = "python3-jinja2"

# https://layers.openembedded.org/layerindex/recipe/4681/
ROS_UNRESOLVED_DEP-file = "file"

# https://layers.openembedded.org/layerindex/recipe/104406/
ROS_UNRESOLVED_DEP-fmt = "fmt"

# https://layers.openembedded.org/layerindex/recipe/120200/
ROS_UNRESOLVED_DEP-libabsl-dev = "abseil-cpp"

# https://layers.openembedded.org/layerindex/recipe/6147/
ROS_UNRESOLVED_DEP-liblttng-ust-dev = "lttng-ust"

# https://layers.openembedded.org/layerindex/recipe/132113/
ROS_UNRESOLVED_DEP-ocl-icd-opencl-dev = "virtual/opencl-icd"

# https://layers.openembedded.org/layerindex/recipe/56447/
ROS_UNRESOLVED_DEP-pybind11-dev = "python3-pybind11"

# https://layers.openembedded.org/layerindex/recipe/51342/
ROS_UNRESOLVED_DEP-python3-dbus = "python3-dbus"

# https://layers.openembedded.org/layerindex/recipe/51298/
ROS_UNRESOLVED_DEP-python3-git = "python3-git"

# https://layers.openembedded.org/layerindex/recipe/148975/
ROS_UNRESOLVED_DEP-python3-jinja2 = "python3-jinja2"

# https://layers.openembedded.org/layerindex/recipe/120600/
ROS_UNRESOLVED_DEP-python3-typeguard = "python3-typeguard"

ROS_UNRESOLVED_DEP-libtins-dev = "libtins"

ROS_UNRESOLVED_DEP-python3-whichcraft = "python3-whichcraft"

# https://layers.openembedded.org/layerindex/recipe/27305/
ROS_UNRESOLVED_DEP-jq = "jq"

ROS_UNRESOLVED_DEP-python3-construct = "python3-construct"

ROS_UNRESOLVED_DEP-python3-jsonschema = "python3-jsonschema"

ROS_UNRESOLVED_DEP-box2d = "box2d"

ROS_UNRESOLVED_DEP-python3-babeltrace = "python3-babeltrace"

ROS_UNRESOLVED_DEP-geos = "geos"

ROS_UNRESOLVED_DEP-python3-venv = "python3"

ROS_UNRESOLVED_DEP-libopencv-imgproc-dev = "opencv"

ROS_UNRESOLVED_DEP-libomp-dev = "openmp"

ROS_UNRESOLVED_DEP-libqt5-svg = "qtsvg"

ROS_UNRESOLVED_DEP-python3-vcstool-native = "python3-vcstool-native"

ROS_UNRESOLVED_DEP-libbluetooth = "bluez5"
ROS_UNRESOLVED_DEP-libbluetooth-dev = "bluez5"

ROS_UNRESOLVED_DEP-libdbus-dev = "dbus"

ROS_UNRESOLVED_DEP-python3-distro = "python3-distro"

ROS_UNRESOLVED_DEP-python3-img2pdf = "python3-img2pdf"

ROS_UNRESOLVED_DEP-python3-ntplib = " python3-ntplib"

ROS_UNRESOLVED_DEP-python3-ntplib = " python3-pydantic"

ROS_UNRESOLVED_DEP-python3-watchdog = "python3-watchdog"

ROS_UNRESOLVED_DEP-python3-protobuf = "python3-protobuf"

ROS_UNRESOLVED_DEP-socat = "socat"

ROS_UNRESOLVED_DEP-python3-scipy = "python3-scipy"

ROS_UNRESOLVED_DEP-libgpiod-dev = "libgpiod"

ROS_UNRESOLVED_DEP-python3-natsort = "python3-natsort"

ROS_UNRESOLVED_DEP-libfyaml-dev = "libfyaml"

ROS_UNRESOLVED_DEP-ignition-math6 = "ignition-math6"

ROS_UNRESOLVED_DEP-ignition-cmake2 = "ignition-cmake2"

ROS_UNRESOLVED_DEP-libpaho-mqtt-dev = "paho-mqtt-c"

ROS_UNRESOLVED_DEP-libpaho-mqttpp-dev = "paho-mqtt-cpp"

ROS_UNRESOLVED_DEP-ignition-transport11 = "ignition-transport11"

ROS_UNRESOLVED_DEP-ignition-msgs8 = "ignition-msgs8"

ROS_UNRESOLVED_DEP-ignition-plugin = "ignition-plugin"

ROS_UNRESOLVED_DEP-ignition-gazebo6 = "ignition-gazebo6"

ROS_UNRESOLVED_DEP-ignition-common4 = "ignition-common4"

ROS_UNRESOLVED_DEP-gazebo = "gazebo"
ROS_UNRESOLVED_DEP-gazebo11 = "gazebo-rosdev"
ROS_UNRESOLVED_DEP-ignition-gazebo6 = "ignition-gazebo6"
ROS_UNRESOLVED_DEP-libgazebo11 = "gazebo11"
ROS_UNRESOLVED_DEP-libgazebo11-dev = "gazebo11"
ROS_UNRESOLVED_DEP-ignition-fortress = "ignition-fortress"
ROS_UNRESOLVED_DEP-ignition-gui6-native = "ignition-gui6-native"

ROS_UNRESOLVED_DEP-libqt5-qml = "qtbase"
ROS_UNRESOLVED_DEP-libqt5-quick = "qtbase"
ROS_UNRESOLVED_DEP-qml-module-qtquick-extras = "qtquickcontrols2"

ROS_UNRESOLVED_DEP-range-v3 = "range-v3"
ROS_UNRESOLVED_DEP-simde = "simde"
ROS_UNRESOLVED_DEP-xsimd = "xsimd"
ROS_UNRESOLVED_DEP-xtensor = "xtensor"

ROS_UNRESOLVED_DEP-libopenni-dev = "openni"
ROS_UNRESOLVED_DEP-libopenni2-dev = "openni2"

ROS_UNRESOLVED_DEP-python3-pydantic = "python3-pydantic"
ROS_UNRESOLVED_DEP-python3-pymap3d = "python3-pymap3d"
ROS_UNRESOLVED_DEP-python3-unidiff = "python3-unidiff"
ROS_UNRESOLVED_DEP-black = "python3-black"
ROS_UNRESOLVED_DEP-black-native = "python3-black-native"

ROS_UNRESOLVED_DEP-libdraco-dev = "draco"
ROS_UNRESOLVED_DEP-sdformat12 = "sdformat"

ROS_UNRESOLVED_DEP-hdf5-tools-native = "hdf5-native"
ROS_UNRESOLVED_DEP-libopenscenegraph = "openscenegraph"
ROS_UNRESOLVED_DEP-wireless-tools = "wireless-tools"
ROS_UNRESOLVED_DEP-warehouse-ros-mongo = "warehouse-ros-mongo"
ROS_UNRESOLVED_DEP-clang-format = "clang"
ROS_UNRESOLVED_DEP-clang-format-native = "clang-native"
ROS_UNRESOLVED_DEP-clang-tidy = "clang"
ROS_UNRESOLVED_DEP-clang-tidy-native = "clang-native"

ROS_UNRESOLVED_DEP-python3-rtree = "python3-rtree"
ROS_UNRESOLVED_DEP-python3-fiona = "python3-fiona"
ROS_UNRESOLVED_DEP-python3-shapely = "python3-shapely"
ROS_UNRESOLVED_DEP-ignition-fuel-tools7 = "ignition-fuel-tools7"
ROS_UNRESOLVED_DEP-python3-uvloop = "python3-uvloop"

ROS_UNRESOLVED_DEP-libgdal-dev = "gdal"
ROS_UNRESOLVED_DEP-python3-smbus = "python3-smbus"
ROS_UNRESOLVED_DEP-libxkbcommon-dev = "libxkbcommon"
ROS_UNRESOLVED_DEP-libavdevice-dev = "ffmpeg"
