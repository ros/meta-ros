# melodic/ros-distro.inc
# General configuration settings that are dependent on ROS_DISTRO.
#
# Copyright (c) 2019 LG Electronics, Inc.

ROS_DISTRO_CODENAME = "Melodic Morenia"

# The platform release that the metadata for this ROS distro targets. This determines the versions of the platform packages that
# OE must provide. It must be one of the values of ROS_DISTRO_RELEASE_PLATFORMS (which is set in
# generated/superflore-ros-distro.inc).
ROS_DISTRO_BASELINE_PLATFORM = "ubuntu-bionic"

require conf/ros-distro/include/melodic/generated/superflore-datetime.inc
require conf/ros-distro/include/melodic/generated/superflore-ros-distro.inc
require conf/ros-distro/include/melodic/ros-distro-recipe-blacklist.inc
require conf/ros-distro/include/melodic/ros-distro-preferred-versions.inc
require conf/ros-distro/include/melodic/ros-distro-preferred-providers.inc

# Override settings from generated/superflore-ros-distro.inc here.

# Since superflore doesn't know when it's generating a recipe that it will be for a build tool, it can't know that what's in
# ROS_EXEC_DEPEND are also build tools. Manually add them here.
ROS_SUPERFLORE_GENERATED_BUILDTOOLS += " \
"

# Must use a _pn- override in this file to override the ROS_BUILD_TYPE of a generated recipe,
# because we need to set this variable before the "inherit" line in the recipe is parsed,
# and having it in a .bbappend sets it too late.
ROS_BUILD_TYPE_pn-python-orocos-kdl = "catkin"

# python-backports-ssl@meta-python
ROS_UNRESOLVED_PLATFORM_PKG_python-backports.ssl-match-hostname = "python-backports-ssl"

# python-pillow@meta-ros v5.1.0
ROS_UNRESOLVED_PLATFORM_PKG_python-imaging = "python-pillow"

# python-tornado45@meta-ros v4.5.3
ROS_UNRESOLVED_PLATFORM_PKG_python-tornado = "python-tornado45"

# python-twisted-core@meta-python (v18.4.0 instead of  bionic's v17.9.0)
ROS_UNRESOLVED_PLATFORM_PKG_python-twisted-core = "python-twisted-core"

# Used by:
# generated-recipes/audio-common/audio-play_0.3.3.bb
# generated-recipes/audio-common/audio-capture_0.3.3.bb
# generated-recipes/audio-common/sound-play_0.3.3.bb
# generated-recipes/gscam/gscam_1.0.1.bb
ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0 = "gstreamer1.0"
ROS_UNRESOLVED_PLATFORM_PKG_libgstreamer1.0-dev = "gstreamer1.0"

# Used by:
# generated-recipes/audio-common/audio-play_0.3.3.bb
# generated-recipes/audio-common/audio-capture_0.3.3.bb
# generated-recipes/audio-common/sound-play_0.3.3.bb
# generated-recipes/gscam/gscam_1.0.1.bb
ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-plugins-base = "gstreamer1.0-plugins-base"
ROS_UNRESOLVED_PLATFORM_PKG_libgstreamer-plugins-base1.0-dev = "gstreamer1.0-plugins-base"

# Used by:
# generated-recipes/audio-common/audio-play_0.3.3.bb
# generated-recipes/audio-common/audio-capture_0.3.3.bb
# generated-recipes/audio-common/sound-play_0.3.3.bb
ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-plugins-good = "gstreamer1.0-plugins-good"

# Used by:
# generated-recipes/audio-common/audio-play_0.3.3.bb
# generated-recipes/audio-common/audio-capture_0.3.3.bb
# generated-recipes/audio-common/sound-play_0.3.3.bb
ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-plugins-ugly = "gstreamer1.0-plugins-ugly"

# Used by:
# generated-recipes/jsk-3rdparty/assimp-devel_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/downward_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/ff_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/libcmt_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/slic_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_ca-certificates = "ca-certificates"

# Used by:
# generated-recipes/rc-genicam-api/rc-genicam-api_2.2.2-1.bb
# generated-recipes/phidgets-drivers/phidgets-api_0.7.9-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libusb-1.0 = "libusb1"

# Used by:
# generated-recipes/kobuki-core/kobuki-ftdi_0.7.8.bb
# generated-recipes/phidgets-drivers/libphidget21_0.7.9-1.bb
# generated-recipes/cob-extern/libphidgets_0.6.14-1.bb
# generated-recipes/joystick-drivers/ps3joy_1.13.0-1.bb
# generated-recipes/schunk-modular-robotics/schunk-sdh_0.6.14-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libusb-dev = "libusb1"

# Used by:
# generated-recipes/pr2-controllers/robot-mechanism-controllers_1.10.17-1.bb
# generated-recipes/jsk-3rdparty/nlopt_2.1.13-1.bb
# generated-recipes/pr2-controllers/ethercat-trigger-controllers_1.10.17-1.bb
# generated-recipes/stage/stage_4.3.0.bb
ROS_UNRESOLVED_PLATFORM_PKG_libtool = "libtool"

# Used by:
# generated-recipes/ros-canopen/socketcan-interface_0.8.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_linux-kernel-headers = "linux-libc-headers"
