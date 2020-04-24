# Copyright (c) 2020 LG Electronics, Inc.

do_configure_append() {
    # Fixes this:
    # distance-map-node/0.1.0-1-r0/recipe-sysroot/usr/include/c++/8.2.0/cstdlib:75:15: fatal error: stdlib.h: No such file or directory
    sed -i 's/-isystem /-I/g' ${B}/build.ninja
}

# distance-map-node/0.1.0-1-r0/recipe-sysroot/usr/opt/ros/melodic/include/distance_map_core/distance_map_converter_instantiater.h:37:89: error: ISO C++ forbids declaration of 'LaserOdometryInstanDistanceMapInstantiatertiater' with no type [-fpermissive]
CXXFLAGS += "-fpermissive"
