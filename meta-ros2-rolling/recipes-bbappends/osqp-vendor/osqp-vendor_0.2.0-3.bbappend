# Copyright (c) 2020 LG Electronics, Inc.

# Instead of fetching
# https://github.com/oxfordcontrol/osqp.git from tag v0.6.2
# during do_compile
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI = " \
    git://github.com/ros2-gbp/osqp_vendor-release;name=release;${ROS_BRANCH};protocol=https \
    file://0002-CMakeLists.txt-fetch-osqp-with-bitbake-fetcher.patch \
    git://github.com/oxfordcontrol/osqp.git;protocol=https;name=osqp;destsuffix=git/osqp-upstream;branch=master \
    git://github.com/oxfordcontrol/qdldl.git;protocol=https;name=qdldl;destsuffix=git/osqp-upstream/lin_sys/direct/qdldl/qdldl_sources;branch=master \
"
SRCREV_release = "dd3878565d2be8dcd2b23e76a08e95b1d2baf89f"
SRCREV_osqp = "f9fc23d3436e4b17dd2cb95f70cfa1f37d122c24"
SRCREV_qdldl = "7d16b70a10a152682204d745d814b6eb63dc5cd2"
SRCREV_FORMAT = "release_osqp_qdldl"
