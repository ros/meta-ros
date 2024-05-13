# Copyright (c) 2020 LG Electronics, Inc.

# Instead of fetching
# https://github.com/cameron314/readerwriterqueue/archive/ef7dfbf553288064347d51b8ac335f1ca489032a.zip
# with curl during do_compile use bitbake git fetcher
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI = " \
    git://github.com/ros2-gbp/rosbag2-release;name=release;${ROS_BRANCH};protocol=https \
    file://0001-CMakeLists.txt-fetch-readerwriterqueue.patch \
    git://github.com/cameron314/readerwriterqueue.git;protocol=https;name=singleproducerconsumer-upstream;destsuffix=git/singleproducerconsumer-upstream;branch=master \
"
SRCREV_release = "2d211121749c26978f1957f8fa0351c243bb2347"
SRCREV_singleproducerconsumer-upstream = "ef7dfbf553288064347d51b8ac335f1ca489032a"

SRCREV_FORMAT = "release_singleproducerconsumer-upstream"
