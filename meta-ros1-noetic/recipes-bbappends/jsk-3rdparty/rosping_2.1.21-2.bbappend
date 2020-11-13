# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fix-build-without-catkin-testing-enab.patch \
    file://0001-CMakeLists.txt-remove-strange-sudo-calls.patch \
"

DEPENDS_append_class-target = " chrpath-replacement-native"
# For some reason ends with bad RPATH
# ERROR: rosping-2.1.13-1-r0 do_package_qa: QA Issue:
# package rosping contains bad RPATH /jenkins/mjansa/build/ros/ros1-melodic-gatesgarth/tmp-glibc/work/core2-64-oe-linux/rosping/2.1.13-1-r0/recipe-sysroot/opt/ros/melodic/lib in file /jenkins/mjansa/build/ros/ros1-melodic-gatesgarth/tmp-glibc/work/core2-64-oe-linux/rosping/2.1.13-1-r0/packages-split/rosping/opt/ros/melodic/lib/rosping/rosping [rpaths]
do_install_append() {
    chrpath --delete ${D}${ros_libdir}/${ROS_BPN}/${ROS_BPN}
}
