# Copyright (c) 2024 Wind River Systems, Inc.

ROS_EXEC_DEPENDS:remove = "gz-cmake3"

# See CMakeLists.txt for details on why /usr/opt/gz_cmake_vendor/ is used
FILES:${PN} += "${datadir}/gz/gz-cmake3/* \
                ${prefix}/opt/gz_cmake_vendor/extra_cmake/lib/cmake/gz-cmake/*"

BBCLASSEXTEND = "native nativesdk"
