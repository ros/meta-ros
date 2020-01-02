# Copyright (c) 2019 LG Electronics, Inc.

# Depends on stage->mesa with this restriction:
inherit distro_features_check
ANY_OF_DISTRO_FEATURES = "opengl vulkan"
