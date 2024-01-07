DESCRIPTION = "Draco is a library for compressing and decompressing 3D geometric meshes and point clouds. It is intended to improve the storage and transmission of 3D graphics."
LICENSE = "Apache-2.0 & MIT & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0f4fd4e8ed0e5c4d26044ac175a3eff8 \
    file://third_party/filesystem/LICENSE;md5=0e30d84046fa808d0addd61d412bc9d1 \
    file://third_party/googletest/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
    file://third_party/tinygltf/LICENSE;md5=82f6e601fc2fd27cbf55d6f5f176d017 \
"

SRC_URI = "gitsm://github.com/google/draco.git;protocol=https;branch=master \
           file://0001-instrumentation.patch"

PV = "1.5.6+git${SRCPV}"
SRCREV = "9f856abaafb4b39f1f013763ff061522e0261c6f"

S = "${WORKDIR}/git"

inherit cmake
