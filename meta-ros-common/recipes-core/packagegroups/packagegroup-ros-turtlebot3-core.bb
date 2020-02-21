# Copyright (c) 2019-2020 LG Electronics, Inc.

SUMMARY = "TurtleBot 3 packages that must be run on the device"

# Need this because the recipe uses MACHINE overrides.
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup
inherit ros_distro_${ROS_DISTRO}

TURTLEBOT3_PACKAGES_LIDAR ??= " \
    hls-lfcd-lds-driver \
"
TURTLEBOT3_PACKAGES_LIDAR_qemux86 = ""

# From just above here http://emanual.robotis.com/docs/en/platform/turtlebot3/appendix_raspi_cam/#run-raspicam-node (also see
# http://emanual.robotis.com/docs/en/platform/turtlebot3/applications/#turtlebot-panorama-demo):
TURTLEBOT3_PACKAGES_CAMERA_rpi ??= " \
    camera-info-manager \
    compressed-image-transport \
"
TURTLEBOT3_PACKAGES_CAMERA_rpi_append_ros1-distro = " \
    raspicam-node \
"
# raspicam-node depends on userland to provide mmal, but for aarch64 it doesn't provide it.
TURTLEBOT3_PACKAGES_CAMERA_remove_aarch64 = "raspicam-node"

TURTLEBOT3_PACKAGES_CAMERA ??= ""

# From http://emanual.robotis.com/docs/en/platform/turtlebot3/raspberry_pi_3_setup/#3-install-dependent-packages-on-turtlebot-pc
RDEPENDS_${PN} = " \
    ros-base \
    turtlebot3-bringup \
    turtlebot3-msgs \
    ${TURTLEBOT3_PACKAGES_CAMERA} \
    ${TURTLEBOT3_PACKAGES_LIDAR} \
"

# Anticipate eventual TurtleBot 3 support under ROS 2, when the package names will be different.
RDEPENDS_${PN}_append_ros1-distro = " \
    rosserial-python \
    tf \
"

# "turtlebot3-bringup" expects "rosdep init; rosdep update" to have been done on the target. This is ROS 1 only.
RDEPENDS_${PN}_append_ros1-distro = " \
    python-rosdep-data \
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
TURTLEBOT3_PACKAGES_CAMERA_remove_rpi = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '', '${TURTLEBOT3_PACKAGES_CAMERA_PACKAGES_DEPENDING_ON_OPENGL_AND_VC4GRAPHICS}', d)}"

TURTLEBOT3_PACKAGES_CAMERA_PACKAGES_DEPENDING_ON_OPENGL_AND_VC4GRAPHICS = " \
    compressed-image-transport \
    raspicam-node \
"
