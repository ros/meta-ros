# Copyright (c) 2021 LG Electronics, Inc.

# meta-ros1-melodic/recipes-bbappends/linux-peripheral-interfaces/libsensors-monitor_%.bbappend says:
# lmsensors package is empty, so not created, we cannot
# have runtime dependency on it
# but there is lmsensors package created at least in dunfell, but there is another issue with it
# that lmsensors rdepends on lmsensors-isatools and isatools package isn't created for !x86
# I've sent backported fix for this:
# https://lists.openembedded.org/g/openembedded-devel/message/93942
# once it's merged, both bbappends can be removed
ROS_EXEC_DEPENDS:remove = "lmsensors"
