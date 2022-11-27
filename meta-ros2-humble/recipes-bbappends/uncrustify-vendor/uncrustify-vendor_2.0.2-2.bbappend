# Copyright (c) 2020 LG Electronics, Inc.

# uncrustify appears in both ROS_BUILD_DEPENDS and ROS_EXPORT_DEPENDS, so it's easier to remove it from DEPENDS.
DEPENDS:remove = "uncrustify"
ROS_EXEC_DEPENDS:remove = "uncrustify"

# Instead of fetching
# https://github.com/uncrustify/uncrustify/archive/45b836cff040594994d364ad6fd3f04adc890a26.tar.gz
# during do_compile
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fetch-uncrustify-with-bitbake-fetcher.patch \
    git://github.com/uncrustify/uncrustify.git;protocol=https;name=uncrustify;destsuffix=git/uncrustify-upstream \
    https://raw.githubusercontent.com/ros2-gbp/uncrustify_vendor-release/release/foxy/uncrustify_vendor/1.4.0-1/install-patch.diff;name=patch;patchdir=uncrustify-upstream \
"
# It's called 0.68.1 in uncrustify_vendor, but it's actually 26 commits after uncrustify-0.69.0 tag
SRCREV_uncrustify = "45b836cff040594994d364ad6fd3f04adc890a26"

SRC_URI[patch.md5sum] = "7561aaffb9d311c50199ec2a8d36ae94"
SRC_URI[patch.sha256sum] = "14a8f11f8e7c68d4363ccf88cc5edb59d4cd6d35086cfdddd98763f596db601e"
