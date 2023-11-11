# Copyright (c) 2020 LG Electronics, Inc.

# Instead of fetching
# https://github.com/oxfordcontrol/osqp.git from tag v0.6.2
# during do_compile
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-user-relative-destination-path.patch \
    file://0002-CMakeLists.txt-fetch-osqp-with-bitbake-fetcher.patch \
    git://github.com/oxfordcontrol/osqp.git;protocol=https;name=osqp;destsuffix=git/osqp-upstream;branch=master \
    git://github.com/oxfordcontrol/qdldl.git;protocol=https;name=qdldl;destsuffix=git/osqp-upstream/lin_sys/direct/qdldl/qdldl_sources;branch=master \
"
SRCREV_osqp = "f9fc23d3436e4b17dd2cb95f70cfa1f37d122c24"
SRCREV_qdldl = "7d16b70a10a152682204d745d814b6eb63dc5cd2"
