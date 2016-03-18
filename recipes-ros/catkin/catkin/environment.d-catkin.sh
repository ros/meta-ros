alias catkin_make=" \
    catkin_make \
    -DCMAKE_TOOLCHAIN_FILE=$OECORE_NATIVE_SYSROOT/usr/share/cmake/OEToolchainConfig.cmake \
    -DSETUPTOOLS_DEB_LAYOUT=OFF \
"
alias catkin_make_isolated=" \
    catkin_make_isolated \
    -DCMAKE_TOOLCHAIN_FILE=$OECORE_NATIVE_SYSROOT/usr/share/cmake/OEToolchainConfig.cmake \
    -DSETUPTOOLS_DEB_LAYOUT=OFF \
"
