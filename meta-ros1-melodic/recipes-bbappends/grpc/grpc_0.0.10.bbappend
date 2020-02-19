# Copyright (c) 2020 LG Electronics, Inc.


# NOTE: VERBOSE=1 cmake --build /jenkins/mjansa/build-ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/grpc/0.0.10-r0/build --target all -- -j 32
# ninja: error: build.ninja:1064: bad $-escape (literal $ must be written as $$)
OECMAKE_GENERATOR = "Unix Makefiles"

# Has dependency on target rsync, but cmake actually checks for native rsync
# CMake Error at CMakeLists.txt:43 (message):
#   Cannot find rsync.
DEPENDS += "rsync-native"

# Prevent webOS OSE .bbappend sneaking this patch:
# https://github.com/webosose/meta-webosose/commit/4903a5bc7ae2b2c0a136c36cfeb840ea4db7fc93
# which is meant for 0.14.1 version from meta-networking from thud:
# https://github.com/openembedded/meta-openembedded/blob/thud/meta-networking/recipes-devtools/grpc/grpc_1.14.1.bb
# which doesn't apply on 0.15.1 based:
# https://github.com/CogRob/catkin_grpc/commit/67c746e3aaa7e6dd04142edd32963da254ea919d
# ros grpc 0.0.10
# newer meta-networking has even newer version since Yocto 3.0 Zeus
# 1.22.0: https://github.com/openembedded/meta-openembedded/commit/cac734087e3c86a4f788c806bc07417f22bdacb9
# 1.24.0: https://github.com/openembedded/meta-openembedded/commit/1ede5a0c181c4562795ab7f9e98889c9a6800d3b
SRC_URI_remove = "file://0001-Don-t-segfault-when-product-name-from-BIOS-is-empty.patch"

# There are still some remaining issues:
# third_party/cares/cares/ares_init.c:301:17: error: argument to 'sizeof' in 'strncpy' call is the same expression as the source; did you mean to use the size of the destination? [-Werror=sizeof-pointer-memaccess]
# cc1: error: unrecognized command line option '-Wno-invalid-source-encoding' [-Werror]
