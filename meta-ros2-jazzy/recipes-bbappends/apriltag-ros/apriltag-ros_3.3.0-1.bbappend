# Copyright (c) 2023 Wind River Systems, Inc.

# apriltag-ros/3.1.2-1-r0/recipe-sysroot/usr/include/apriltag/common/matd.h:48:12: error: ISO C++ forbids flexible array member 'data' [-Werror=pedantic]
CXXFLAGS += "-Wno-error=pedantic"

# apriltag-ros/3.1.1-3-r0/recipe-sysroot/usr/include/libstatistics_collector/libstatistics_collector/topic_statistics_collector/received_message_period.hpp:174:32: error: unused parameter 'message_info' [-Werror=unused-parameter]
CXXFLAGS += "-Wno-error=unused-parameter"

# tf2/convert.h is intentionally obsolete and triggers a warning (fatal under -Werror)
do_configure:append() {
    sed -i \
      -e 's#<tf2/convert.h>#<tf2/convert.hpp>#g' \
      ${S}/src/pose_estimation.cpp \
      ${S}/src/conversion.cpp
}
