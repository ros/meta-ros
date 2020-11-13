# Copyright (c) 2020 LG Electronics, Inc.

# Instead of fetching
# https://github.com/flexible-collision-library/fcl/archive/v0.6.1.zip with curl
# during do_compile
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fetch-fcl-with-bitbake-fetcher.patch \
    git://github.com/flexible-collision-library/fcl.git;protocol=https;name=fcl-upstream;destsuffix=git/fcl-upstream \
"
SRCREV_fcl-upstream = "97455a46de121fb7c0f749e21a58b1b54cd2c6be"

# WARNING: fcl-catkin-0.6.0-1-r0 do_package: QA Issue: fcl-catkin: Files/directories were installed but not shipped in any package:
#   /opt/ros/melodic/lib/libfcl.so.0.6
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# fcl-catkin: 1 installed and not shipped files. [installed-vs-shipped]
FILES_${PN} += "${ros_libdir}/*${SOLIBS}"
