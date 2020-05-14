# Copyright (c) 2020 LG Electronics, Inc.

# Drop -s to fix:
# ERROR: QA Issue: File '/usr/opt/ros/melodic/lib/imagezero/image_zero' from imagezero was already stripped, this will prevent future debugging! [already-stripped]
do_configure_prepend() {
    sed -i 's#^set(CMAKE_EXE_LINKER_FLAGS "-Wl,-O1,-s,--no-export-dynamic")$#set(CMAKE_EXE_LINKER_FLAGS "-Wl,-O1,--no-export-dynamic")#g' ${S}/CMakeLists.txt
}

# Used only to pass "-mmmx -mtune=corei7-avx" when ARCHITECTURE is x86_64
EXTRA_OECMAKE += "-DARCHITECTURE=${TUNE_ARCH}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-detect-ARCHITECTURE-only-when-not-set.patch"
