# Copyright (c) 2019-2020 LG Electronics, Inc.
#
# Add INHERIT, DISTRO_FEATURES (without those that start with "libc-"), MACHINE_FEATURES, IMAGE_FEATURES, and, if it's not just
# whitespace, IMAGE_FSTYPES to what's shown as the build configuration by adding:
#
#   require conf/distro/include/ros-useful-buildcfg-vars.inc
#
# to your conf/local.conf .

# Note that d.getVar() returns None if the variable is unset, and NoneType doesn't have a .split().

DISTRO_FEATURES_NO_LIBC = "${@ ' '.join(sorted(set([f for f in (d.getVar('DISTRO_FEATURES') or '').split() if not f.startswith('libc-')]))) }"
ROS_EXTRA_BUILDCFG_VARS_append = " INHERIT DISTRO_FEATURES_NO_LIBC MACHINE_FEATURES IMAGE_FEATURES"

# Include LICENSE_FLAGS_WHITELIST unless it's unset or just whitespace.
ROS_EXTRA_BUILDCFG_VARS_append = "${@ ' LICENSE_FLAGS_WHITELIST' if len((d.getVar('LICENSE_FLAGS_WHITELIST') or '').split()) > 0 else '' }"

# Include IMAGE_FSTYPES unless it's unset or just whitespace.
ROS_EXTRA_BUILDCFG_VARS_append = "${@ ' IMAGE_FSTYPES' if len((d.getVar('IMAGE_FSTYPES') or '').split()) > 0 else '' }"
