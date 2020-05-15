# Copyright (c) 2020 LG Electronics, Inc.

# exotica-core/5.1.3-3-r0/git/include/exotica_core/visualization_meshcat.h:34:10: fatal error: zmq.hpp: No such file or directory
ROS_BUILD_DEPENDS += "cppzmq"

# exotica-core/5.1.3-3-r0/git/include/exotica_core/tools/conversions.h:230:9: error: catching polymorphic type 'class std::invalid_argument' by value [-Werror=catch-value=]
CXXFLAGS += "-Wno-error=catch-value="
