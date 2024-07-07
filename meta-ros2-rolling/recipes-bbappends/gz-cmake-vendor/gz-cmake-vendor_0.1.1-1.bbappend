# Copyright (c) 2024 Wind River Systems, Inc.

export GZ_RELAX_VERSION_MATCH="1"

ROS_BUILD_DEPENDS += "gz-cmake3"

# See CMakeLists.txt for details on why /usr/opt/gz_cmake_vendor/ is used
FILES:${PN} += "${datadir}/gz/gz-cmake3/* \
                ${prefix}/opt/gz_cmake_vendor/extra_cmake/lib/cmake/gz-cmake/*"

BBCLASSEXTEND = "native nativesdk"
