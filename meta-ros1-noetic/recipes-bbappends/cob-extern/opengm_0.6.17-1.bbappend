# Copyright (c) 2021 LG Electronics, Inc.

# Instead of fetching
# https://github.com/ipa320/thirdparty/raw/master/opengm-master.tar.gz
# during do_compile fetch it with bitbake's git fetcher
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fetch-opengm-with-bitbake-fetcher.patch \
    https://github.com/ipa320/thirdparty/raw/2586d6a6ce48a17f355f036c6a64aef8c90660c9/opengm-master.tar.gz;name=opengm;subdir=git/opengm-upstream \
    file://0001-CMakeLists.txt-fix-if-else-statement.patch;patchdir=opengm-upstream/opengm-master \
"
SRC_URI[opengm.sha256sum] = "4eacf8eccfd8c969fb3c83180a7abc03753da735b74d2337d5442ebdfbdf6c12"
