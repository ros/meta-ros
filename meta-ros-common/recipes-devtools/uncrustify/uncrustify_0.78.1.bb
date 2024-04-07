SUMMARY = "A highly configurable, easily modifiable source code beautifier for C, C++, C#, ObjectiveC, D, Java, Pawn and VALA"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f \
                    file://package.json;md5=dcbffda08426a91939bf2a9f1496e1d2"

SRC_URI = "git://github.com/uncrustify/uncrustify.git;protocol=https;branch=master"
SRCREV = "b8c95286f70ef8e0e83bd055a3a7aabb614a0781"

S = "${WORKDIR}/git"

inherit cmake

BBCLASSEXTEND = "native"
