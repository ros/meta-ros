# Copyright (c) 2021 LG Electronics, Inc.

# used only as runtime dependency, but there is no ode/libode recipe, try to set it empty to test in runtime if this new dependency from 1.5.2 version is really mandatory
# https://github.com/ompl/ompl/compare/1.5.1...1.5.2
# https://github.com/ompl/ompl/commit/bb0a03c6fe4fbba0282c9a58881c3f499e7564d0 says it's optional
ROS_UNRESOLVED_DEP-opende = ""
