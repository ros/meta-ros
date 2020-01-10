# Copyright (c) 2020 LG Electronics, Inc.

# Depends on gstreamer1.0-* with this restriction:
inherit features_check
REQUIRED_DISTRO_FEATURES_append_rpi = " opengl"
