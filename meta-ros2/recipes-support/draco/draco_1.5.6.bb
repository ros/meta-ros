DESCRIPTION = "Draco is a library for compressing and decompressing 3D geometric meshes and point clouds. It is intended to improve the storage and transmission of 3D graphics."
LICENSE = "Apache-2.0 & MIT & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0f4fd4e8ed0e5c4d26044ac175a3eff8 \
    file://third_party/filesystem/LICENSE;md5=0e30d84046fa808d0addd61d412bc9d1 \
    file://third_party/googletest/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
    file://third_party/tinygltf/LICENSE;md5=82f6e601fc2fd27cbf55d6f5f176d017 \
"

SRC_URI = "gitsm://github.com/google/draco.git;protocol=https;branch=main \
           file://fix-install-path.patch"

SRCREV = "8786740086a9f4d83f44aa83badfbea4dce7a1b5"

S = "${WORKDIR}/git"

inherit cmake
