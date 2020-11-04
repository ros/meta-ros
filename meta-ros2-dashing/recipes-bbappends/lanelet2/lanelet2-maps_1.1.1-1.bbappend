# Copyright (c) 2020 LG Electronics, Inc.

# Uses rospkg/os_detect.py at build time resulting in:
# | CMake Error at /jenkins/mjansa/build/ros/webos-dashing-dunfell/tmp-glibc/work/qemux86-webos-linux/lanelet2-maps/1.1.1-1-r0/recipe-sysroot-native/usr/share/mrt_cmake_modules/cmake/Modules/GatherDeps.cmake:24 (message):
# |   Gather depenencies failed: Traceback (most recent call last):
# |
# |     File "/jenkins/mjansa/build/ros/webos-dashing-dunfell/tmp-glibc/work/qemux86-webos-linux/lanelet2-maps/1.1.1-1-r0/recipe-sysroot-native/usr/share/mrt_cmake_modules/cmake/../scripts/generate_cmake_dependency_file.py", line 368, in <module>
# |       main(sys.argv[1], sys.argv[2], sys.argv[3])
# |     File "/jenkins/mjansa/build/ros/webos-dashing-dunfell/tmp-glibc/work/qemux86-webos-linux/lanelet2-maps/1.1.1-1-r0/recipe-sysroot-native/usr/share/mrt_cmake_modules/cmake/../scripts/generate_cmake_dependency_file.py", line 299, in main
# |       cmakeVarData = readPackageCMakeData(rosDepYamlFileName)
# |     File "/jenkins/mjansa/build/ros/webos-dashing-dunfell/tmp-glibc/work/qemux86-webos-linux/lanelet2-maps/1.1.1-1-r0/recipe-sysroot-native/usr/share/mrt_cmake_modules/cmake/../scripts/generate_cmake_dependency_file.py", line 146, in readPackageCMakeData
# |       distribution = OsDetect().detect_os()[2]
# |     File "/jenkins/mjansa/build/ros/webos-dashing-dunfell/tmp-glibc/work/qemux86-webos-linux/lanelet2-maps/1.1.1-1-r0/recipe-sysroot-native/usr/lib/python3.8/site-packages/rospkg/os_detect.py", line 655, in detect_os
# |       raise OsNotDetected("Could not detect OS, tried %s" % attempted)
# |
# |   rospkg.os_detect.OsNotDetected: Could not detect OS, tried ['windows',
# |   'nixos', 'clearlinux', 'ubuntu', 'slackware', 'rhel', 'qnx', 'osx',
# |   'tizen', 'opensuse', 'opensuse', 'opensuse', 'openembedded', 'neon', 'mx',
# |   'mint', 'linaro', 'gentoo', 'funtoo', 'freebsd', 'fedora', 'elementary',
# |   'elementary', 'debian', 'cygwin', 'centos', 'manjaro', 'arch', 'alpine']
do_configure_prepend() {
    export ROS_OS_OVERRIDE="openembedded"
}
