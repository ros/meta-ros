SUMMARY = "A highly configurable, easily modifiable source code beautifier for C, C++, C#, ObjectiveC, D, Java, Pawn and VALA"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   tests/cli/config/copyright-header.cfg
#   tests/cli/config/copyright-header.txt
#   tests/cli/output/copyright-header.cpp
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "GPLv2 & Unknown"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f \
                    file://tests/cli/config/copyright-header.cfg;md5=4433a6f744a8775490b71430c0c4c57e \
                    file://tests/cli/config/copyright-header.txt;md5=9d650176fa4899e13c8f541109878777 \
                    file://tests/cli/output/copyright-header.cpp;md5=65c3951fdb0755160a989c87569e062c \
                    file://package.json;md5=b43f590b0d3f887322788d4522c747ad"

SRC_URI = " \
    git://github.com/uncrustify/uncrustify.git;protocol=https;branch=uncrustify-0.75.x \
    "
SRCREV = "639856e61770c785b5b85612e9a431d720fd8e4f"

S = "${WORKDIR}/git"

inherit cmake

BBCLASSEXTEND = "native"

