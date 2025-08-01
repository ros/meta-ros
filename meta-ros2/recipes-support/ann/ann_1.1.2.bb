DESCRIPTION = "ANN: A Library for Approximate Nearest Neighbor Searching"
HOMEPAGE = "https://www.cs.umd.edu/~mount/ANN/"
LICENSE = "LGPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://Copyright.txt;md5=edbdc75a273d9abf3efd845acce53779 \
                    file://License.txt;md5=af12805d8bdbd3c30da0186f62dd0180 \
                    file://debian/copyright;md5=32dd5c77226ce8d52d4d865689aea1f2 \
                    file://doc/Copyright.txt;md5=c694851d3786763c687b91b4fd742858 \
                    file://doc/License.txt;md5=af12805d8bdbd3c30da0186f62dd0180"

SRC_URI = "git://salsa.debian.org/science-team/ann.git;protocol=https;branch=master \
    file://makefile-infloop-fix.diff \
    file://doc-makefile-clean.diff \
    file://autotools-files.diff \
    file://consider-pts-null.diff \
    file://annkFRSearch-default-argument.diff \
    file://clang-ftbfs.diff \
    file://0007-update-autotools-file-for-the-cctbx-variant.patch \
    file://autotools-fixup.patch \
"

PV = "1.1.2"
SRCREV = "c571ae9f9830a380074fe1c03fc30bf31c440ed7"

inherit python3native autotools-brokensep

do_configure:prepend() {
    for FILE in Makefile src/Makefile ann2fig/Makefile sample/Makefile test/Makefile; do \
        if [ -f $FILE ]; then mv ${S}/$FILE ${S}/$FILE.orig; fi \
    done

    # Add missing GNU standard files to appease automake
    touch ${S}/NEWS ${S}/AUTHORS ${S}/ChangeLog ${S}/README
    cp ${S}/License.txt ${S}/COPYING

    # Patch the ANN library for cctbx
    # This isn't technically necessary, but keeps us aligned to Debian's changes
    cd ${S} && ./debian/cctbx
}
