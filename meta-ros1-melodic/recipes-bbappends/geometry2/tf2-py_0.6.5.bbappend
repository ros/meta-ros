# Copyright (c) 2019 LG Electronics, Inc.

DEPENDS_append_class-target = " chrpath-replacement-native"

# For some reason _tf2.so ends with bad RPATH
# package tf2-py contains bad RPATH BUILD/work/i586-oe-linux/tf2-py/0.6.5-r0/recipe-sysroot/opt/ros/melodic/lib in file BUILD/work/i586-oe-linux/tf2-py/0.6.5-r0/packages-split/tf2-py/opt/ros/melodic/lib/python2.7/site-packages/tf2_py/_tf2.so [rpaths]

# roslz4 builds python library as well and do_configure generates rpath only to catkin workspace:
# work/i586-oe-linux/roslz4/1.14.3-r0$ grep LINK_LIBRARIES build/build.ninja
#   LINK_LIBRARIES = -llz4
#   LINK_LIBRARIES = -Wl,-rpath,BUILD/work/i586-oe-linux/roslz4/1.14.3-r0/devel/lib: BUILD/work/i586-oe-linux/roslz4/1.14.3-r0/devel/lib/libroslz4.so -lpython2.7 -llz4
#
# tf2-py is similar, but instead of catkin workspace we end with a path to RSS:
# work/i586-oe-linux/tf2-py/0.6.5-r0$ grep LINK_LIB build.ninja
#   LINK_LIBRARIES = -Wl,-rpath,BUILD/work/i586-oe-linux/tf2-py/0.6.5-r0/recipe-sysroot/opt/ros/melodic/lib recipe-sysroot/opt/ros/melodic/lib/libtf2.so recipe-sysroot/opt/ros/melodic/lib/libroscpp_serialization.so recipe-sysroot/opt/ros/melodic/lib/librostime.so recipe-sysroot/opt/ros/melodic/lib/libcpp_common.so -lboost_system-mt -lboost_thread-mt -lboost_chrono-mt -lboost_date_time-mt -lboost_atomic-mt recipe-sysroot/usr/lib/libconsole_bridge.so.0.4

# It's not set anywhere in CMakeLists.txt and running cmake even with --trace --debug-output doesn't show
# anything about where this rpath came from to ninja's LINK_LIBRARIES

do_install_append() {
    chrpath --delete ${D}${PYTHON_SITEPACKAGES_DIR}/tf2_py/_tf2.so
}
