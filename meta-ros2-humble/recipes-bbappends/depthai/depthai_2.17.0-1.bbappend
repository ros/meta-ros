ROS_BUILD_DEPENDS = " \
    bzip2 \
    fp16 \
    libarchive \
    libnop-luxonis \
    xlink \
    xz \
    spdlog \
    zlib \
"

EXTRA_OECMAKE = " \
    -DHUNTER_ENABLED=OFF \
    -DDEPTHAI_ENABLE_BACKWARD=OFF \
    -DDEPTHAI_OPENCV_SUPPORT=OFF \
    -DDEPTHAI_CLANG_FORMAT=OFF \
    -DDEPTHAI_BINARIES_RESOURCE_COMPILE=OFF \
    -DHUNTER_INSTALL_PREFIX=${D} \
"