# Copyright (c) 2020 LG Electronics, Inc.

# Instead of fetching
# https://github.com/oxfordcontrol/osqp.git from tag v0.6.1-dev0
# during do_compile fetch v0.6.2, because v0.6.1-dev0 tag was deleted in osqp repo
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-user-relative-destination-path.patch \
    file://0002-CMakeLists.txt-fetch-osqp-with-bitbake-fetcher.patch \
    file://0003-CMakeLists.txt-adjust-to-make-catkin-happy.patch \
    git://github.com/oxfordcontrol/osqp.git;protocol=https;name=osqp;destsuffix=git/osqp-upstream;branch=master \
    git://github.com/oxfordcontrol/qdldl.git;protocol=https;name=qdldl;destsuffix=git/osqp-upstream/lin_sys/direct/qdldl/qdldl_sources;branch=master \
"
SRCREV_osqp = "f9fc23d3436e4b17dd2cb95f70cfa1f37d122c24"
SRCREV_qdldl = "7d16b70a10a152682204d745d814b6eb63dc5cd2"

# ERROR: osqp-vendor-0.1.2-1-r0 do_package: QA Issue: osqp-vendor: Files/directories were installed but not shipped in any package:
#   /usr/opt/ros/noetic/lib/cmake
#   /usr/opt/ros/noetic/lib/cmake/osqp
#   /usr/opt/ros/noetic/lib/cmake/qdldl
#   /usr/opt/ros/noetic/lib/cmake/osqp/osqp-config.cmake
#   /usr/opt/ros/noetic/lib/cmake/osqp/osqp-targets.cmake
#   /usr/opt/ros/noetic/lib/cmake/osqp/osqp-targets-noconfig.cmake
#   /usr/opt/ros/noetic/lib/cmake/qdldl/qdldl-targets.cmake
#   /usr/opt/ros/noetic/lib/cmake/qdldl/qdldl-config.cmake
#   /usr/opt/ros/noetic/lib/cmake/qdldl/qdldl-targets-noconfig.cmake
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# osqp-vendor: 9 installed and not shipped files. [installed-vs-shipped]
FILES:${PN}-dev += "${ros_libdir}/cmake"
