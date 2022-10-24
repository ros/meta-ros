# | CMake Error at /tmp/sandeepg/yocto/2023.1/build-zcu102/work/x86_64-linux/rosidl-runtime-c-native/3.1.3-2-r0/recipe-sysroot-native/usr/share/rcutils/cmake/ament_cmake_export_targets-extras.cmake:18 (message):
# |   Failed to find exported target names in
# |   '/tmp/sandeepg/yocto/2023.1/build-zcu102/work/x86_64-linux/rosidl-runtime-c-native/3.1.3-2-r0/recipe-sysroot-native/usr/share/rcutils/cmake/rcutilsExport.cmake'
# | Call Stack (most recent call first):
# |   /tmp/sandeepg/yocto/2023.1/build-zcu102/work/x86_64-linux/rosidl-runtime-c-native/3.1.3-2-r0/recipe-sysroot-native/usr/share/rcutils/cmake/rcutilsConfig.cmake:41 (include)
# |   CMakeLists.txt:15 (find_package)
# |
# |
# | -- Configuring incomplete, errors occurred!

# With Langdale CMake 3.24 version change the new target export template
# Cherry pick patch from ament_cmake rolling version
# https://github.com/ament/ament_cmake/commit/ca8c26ea3c89e69c0c636b7cd0c088674c689f5f

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-Support-new-target-export-template-introduced-with-C.patch;striplevel=2 \
    "
