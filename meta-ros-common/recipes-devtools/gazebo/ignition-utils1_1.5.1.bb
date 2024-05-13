LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://LICENSE;md5=881ceadb4a5b6db70a8a48a5f5f0050f \
                    file://cli/LICENSE;md5=b73927b18d5c6cd8d2ed28a6ad539733"

SRC_URI = "git://github.com/gazebosim/gz-utils.git;protocol=https;branch=ign-utils1"

SRCREV = "36f5dfdbccd6cce7e02df14a2db19c6c2e784c49"

S = "${WORKDIR}/git"

# NOTE: unable to map the following CMake package dependencies: ignition-cmake2
inherit cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

DEPENDS = "ignition-cmake2"

BBCLASSEXTEND = "native nativesdk"
