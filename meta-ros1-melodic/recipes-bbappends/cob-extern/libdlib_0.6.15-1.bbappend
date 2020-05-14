# Copyright (c) 2020 LG Electronics, Inc.

# Instead of fetching
# https://github.com/ipa320/thirdparty/raw/master/dlib-${VERSION}.tar.bz2 with curl
# during do_compile
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fetch-dlib-with-bitbake-fetcher.patch \
    http://dlib.net/files/dlib-19.9.tar.bz2;name=dlib;subdir=git/dlib-upstream \ 
"
SRC_URI[dlib.md5sum] = "4a3868a1e88721b68ccfb0567eaac87b"
SRC_URI[dlib.sha256sum] = "ec6374745d24b53568ae4d171b2ad86d102ae238dbdb093b462d5c8ae48b65b9"

# This is failing only in webOS OSE
DEPENDS += "libnsl2"
