# Blacklist all failing task for CI jobs to easily compare
# if "bitbake world" is getting better or worse

# LICENSE_FLAGS_WHITELIST restrictions
ROS_WORLD_SKIP_GROUPS += "world-license"

PNBLACKLIST[gstreamer1.0-plugins-bad] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'depends on faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[gstreamer1.0-vaapi] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'depends on gstreamer1.0-plugins-bad->faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[webkitgtk] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'depends on gstreamer1.0-plugins-bad->faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[epiphany] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'depends on webkitgtk->gstreamer1.0-plugins-bad->faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[packagegroup-self-hosted] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'depends on epiphany->webkitgtk->gstreamer1.0-plugins-bad->faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[clutter-gst-3.0] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'depends on gstreamer1.0-plugins-bad->faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[packagegroup-core-clutter] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'depends on clutter-gst-3.0->gstreamer1.0-plugins-bad->faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[omxplayer] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'depends on libav, libomxil which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[gst-examples] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'depends on gstreamer1.0-plugins-bad which depends on faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[packagegroup-core-x11-sato] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-license', 'depends on gst-examples which depends on gstreamer1.0-plugins-bad which depends on faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST', '', d)}"
PNBLACKLIST[packagegroup-core-tools-testapps] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['world-license', 'python2'], 'world-license: depends on gst-examples which depends on gstreamer1.0-plugins-bad which depends on faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST; python: depends on python2', '', d)}"

# Other issues:
ROS_WORLD_SKIP_GROUPS += "world-issues"
PNBLACKLIST[wiringpi] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-issues', 'Fails to fetch: git.drogon.net[0: 188.246.205.22]: errno=Connection refused', '', d)}"
PNBLACKLIST[packagegroup-rpi-test] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['world-issues', 'python2'], 'world-issues: Depends on blacklisted packages like wiringpi and recipes from meta-multimedia we do not depend on: bigbuckbunny-480p, bigbuckbunny-720p, bigbuckbunny-1080p and wireless-regdb from meta-networking; python2: Depends on blacklisted python2', '', d)}"
PNBLACKLIST[kernel-selftest] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-issues', 'Fails to build with linux-yocto kernel: WARNING: clang >= 6.0  with bpf support is needed with kernel 4.18+ so either install it and add it to HOSTTOOLS, or add clang-native from meta-clang to dependency and then /bin/sh: 1: llc: not found + /bin/sh: 1: clang: not found + /bin/sh: 1: llvm-readelf: not found', '', d)}"
PNBLACKLIST[vboxguestdrivers] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-issues', 'Fails to build with linux-yocto kernel: vboxguestdrivers/5.2.22-r0/vbox_module/vboxguest/r0drv/linux/time-r0drv-linux.c:175:5: error: implicit declaration of function ktime_get_real_ts; did you mean ktime_get_real_ns? [-Werror=implicit-function-declaration]', '', d)}"
PNBLACKLIST[libmodulemd-v1] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-issues', 'Fails to build with libyaml-vendor from meta-ros instead of regular libyaml: meson.build:54:0: ERROR:  Dependency yaml-0.1 not found, tried pkgconfig', '', d)}"
PNBLACKLIST[libmodulemd] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-issues', 'Fails to build with libyaml-vendor from meta-ros instead of regular libyaml: meson.build:54:0: ERROR:  Dependency yaml-0.1 not found, tried pkgconfig', '', d)}"
PNBLACKLIST[libdnf] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-issues', 'Depends on blacklisted libmodulemd', '', d)}"
PNBLACKLIST[dnf] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-issues', 'Depends on blacklisted libdnf->libmodulemd', '', d)}"
PNBLACKLIST[dnfdragora] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-issues', 'Depends on blacklisted dnf->libdnf->libmodulemd', '', d)}"
PNBLACKLIST[dnf-plugin-tui] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-issues', 'Depends on blacklisted dnf->libdnf->libmodulemd', '', d)}"
PNBLACKLIST[createrepo-c] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-issues', 'Depends on blacklisted libmodulemd', '', d)}"
PNBLACKLIST[renderdoc] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-issues', 'Depends on mesa-gl without setting correct REQUIRED_DISTRO_FEATURES to match it: mesa-gl PROVIDES virtual/libgl but was skipped: one of vulkan opengl needs to be in DISTRO_FEATURES', '', d)}"
PNBLACKLIST[python-ldap] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-issues', 'Depends on cyrus-sasl from meta-networking, skipped since http://lists.openembedded.org/pipermail/openembedded-devel/2020-February/205123.html', '', d)}"
PNBLACKLIST[python-networkmanager] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-issues', 'Depends on networkmanager, skipped since http://lists.openembedded.org/pipermail/openembedded-devel/2020-February/205124.html', '', d)}"
PNBLACKLIST[perf] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-issues', 'Fails for raspberrypi, linux-raspberrypi needs kernel patch to fix perf build with binutils-2.34, fixed in: https://github.com/agherzan/meta-raspberrypi/pull/586"
PNBLACKLIST[oprofile] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'world-issues', 'world-issues: Fails to build: ERROR: oprofile-1.3.0-r0 do_compile: oe_runmake failed: oprofile-1.3.0/libutil++/bfd_support.cpp:140:53: error: cannot convert bfd* to const asection* {aka const bfd_section*} fixed in http://git.openembedded.org/meta-openembedded/commit/?id=d280be7d5d6238ef7024c1a89277dabbe7e08c2b', '', d)}"

# Depends on c-ares from meta-networking
# Fixed in http://lists.openembedded.org/pipermail/openembedded-devel/2020-February/205122.html
PACKAGECONFIG_remove_pn-nodejs = "ares"
PACKAGECONFIG_remove_pn-nodejs-native = "ares"
# Depends on cyrus-sasl from meta-networking
# Fixed in http://lists.openembedded.org/pipermail/openembedded-devel/2020-February/205122.html
# Otherwise needs x11vnc and remmina to be blacklisted as well
PACKAGECONFIG_remove_pn-libvncserver = "sasl"

PNBLACKLIST[packagegroup-meta-oe] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['world-issues', 'python2'], 'world-issues: Depends on blacklisted packages like libvncserver,x11vnc; python2: Depends on blacklisted python2', '', d)}"
PNBLACKLIST[packagegroup-core-tools-profile] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['world-issues', 'python2'], 'world-issues: Depends on blacklisted perf; python2: Depends on blacklisted python2', '', d)}"

PNBLACKLIST[userland] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opengl', 'depends on libegl-mesa from mesa-gl which is not available without opengl in DISTRO_FEATURES', '', d)}"
