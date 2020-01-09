# Copyright (c) 2019 LG Electronics, Inc.

# Depends on gstreamer1.0-python which requires gobject-introspection-data in DISTRO_FEATURES
inherit distro_features_check
REQUIRED_DISTRO_FEATURES = "gobject-introspection-data"
