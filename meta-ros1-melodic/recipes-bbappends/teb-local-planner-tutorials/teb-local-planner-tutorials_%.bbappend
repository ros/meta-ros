# Copyright (c) 2019 LG Electronics, Inc.

# Depends on teb-local-planner->libg2o->mesa with this restriction:
inherit distro_features_check
ANY_OF_DISTRO_FEATURES = "opengl vulkan"
