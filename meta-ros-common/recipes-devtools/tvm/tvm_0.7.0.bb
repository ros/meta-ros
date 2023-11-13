# Copyright (c) 2021 LG Electronics, Inc.

SUMMARY = "Open Deep Learning Compiler Stack"
HOMEPAGE = "https://tvm.apache.org/"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e313a9b6eda820e35716d9529001537f"

# matches with tag 0.7.0
SRCREV_tvm = "728b829575e5e690870b111ae2256cbe0f3dbe6f"
SRCREV_dlmc-core = "6c401e242c59a1f4c913918246591bb13fd714e7"
SRCREV_dlpack = "3ec04430e89a6834e5a1b99471f415fa939bf642"
SRCREV_rang = "cabe04d6d6b05356fa8f9741704924788f0dd762"
SRCREV_vta-hw = "87ce9acfae550d1a487746e9d06c2e250076e54c"
SRCREV_FORMAT = "tvm_dlmc-core_dlpack_rang_vta-hw"

SRC_URI = "git://github.com/apache/tvm;name=tvm;branch=main;protocol=https \
    git://github.com/dmlc/dmlc-core;name=dlmc-core;destsuffix=git/3rdparty/dmlc-core;branch=master;protocol=https \
    git://github.com/dmlc/dlpack;name=dlpack;destsuffix=git/3rdparty/dlpack;branch=master;protocol=https \
    git://github.com/agauniyal/rang;name=rang;destsuffix=git/3rdparty/rang;branch=master;protocol=https \
    git://github.com/apache/incubator-tvm-vta;name=vta-hw;destsuffix=git/3rdparty/vta-hw;branch=master;protocol=https \
"

S = "${WORKDIR}/git"

inherit cmake

# ERROR: tvm-0.7.0-r0 do_package_qa: QA Issue:
# -dev package contains non-symlink .so: tvm-dev path '/work/qemux86-webos-linux/tvm/0.7.0-r0/packages-split/tvm-dev/usr/lib/libtvm.so'
# -dev package contains non-symlink .so: tvm-dev path '/work/qemux86-webos-linux/tvm/0.7.0-r0/packages-split/tvm-dev/usr/lib/libtvm_runtime.so' [dev-elf]
FILES_SOLIBSDEV = ""
FILES:${PN} += " \
    ${libdir}/lib*${SOLIBSDEV} \
"
