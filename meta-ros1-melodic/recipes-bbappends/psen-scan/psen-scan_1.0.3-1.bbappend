# Copyright (c) 2020 LG Electronics, Inc.

# Ignore this for now
# psen-scan/1.0.3-1-r0/temp/log.do_compile.59642:/jenkins/mjansa/build-ros/ros1-melodic-zeus/tmp-glibc/work/aarch64-oe-linux/psen-scan/1.0.3-1-r0/git/src/ros_scanner_node.cpp:51:56: error: implicitly-declared 'ros::Publisher& ros::Publisher::operator=(const ros::Publisher&)' is deprecated [-Werror=deprecated-copy]
# psen-scan/1.0.3-1-r0/temp/log.do_compile.59642:/jenkins/mjansa/build-ros/ros1-melodic-zeus/tmp-glibc/work/aarch64-oe-linux/psen-scan/1.0.3-1-r0/git/src/ros_scanner_node.cpp:51:56: error: implicitly-declared 'ros::Publisher& ros::Publisher::operator=(const ros::Publisher&)' is deprecated [-Werror=deprecated-copy]
CXXFLAGS += "-Wno-error=deprecated-copy"
