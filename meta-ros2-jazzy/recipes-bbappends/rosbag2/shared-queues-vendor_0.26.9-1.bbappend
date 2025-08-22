# Copyright (c) 2020 LG Electronics, Inc.

# Instead of fetching
# https://github.com/cameron314/readerwriterqueue/archive/ef7dfbf553288064347d51b8ac335f1ca489032a.zip
# https://github.com/cameron314/concurrentqueue/archive/8f65a8734d77c3cc00d74c0532efca872931d3ce.zip
# with curl during do_compile use bitbake git fetcher
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI = " \
    git://github.com/ros2-gbp/rosbag2-release;name=release;${ROS_BRANCH};protocol=https \
    file://0001-CMakeLists.txt-fetch-readerwriterqueue-and-concurren.patch \
    git://github.com/cameron314/readerwriterqueue.git;protocol=https;name=singleproducerconsumer-upstream;destsuffix=git/singleproducerconsumer-upstream;branch=master \
    git://github.com/cameron314/concurrentqueue.git;protocol=https;name=concurrentqueue-upstream;destsuffix=git/concurrentqueue-upstream;branch=master \
"
SRCREV_release = "dc17fed08353f30a7e20676df7c8fc5e842ed011"
SRCREV_singleproducerconsumer-upstream = "ef7dfbf553288064347d51b8ac335f1ca489032a"
SRCREV_concurrentqueue-upstream = "8f65a8734d77c3cc00d74c0532efca872931d3ce"

SRCREV_FORMAT = "release_singleproducerconsumer-upstream_concurrentqueue-upstream"
