# This class injects google test in the directory given by
# GTEST_DESTDIR (S by default)

SRC_URI += "https://googletest.googlecode.com/files/gtest-1.6.0.zip;name=gtest"

SRC_URI[gtest.md5sum] = "4577b49f2973c90bf9ba69aa8166b786"
SRC_URI[gtest.sha256sum] = "5ec97df8e75b4ee796604e74716d1b50582beba22c5502edd055a7e67a3965d8"

GTEST_DESTDIR ?= "${S}"

do_configure_prepend () {
    ln -s ${WORKDIR}/gtest-1.6.0 ${GTEST_DESTDIR}/gtest
}
