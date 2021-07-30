# restore python2 version removed in:
# http://git.openembedded.org/openembedded-core/commit/?h=zeus&id=4e9659f24e2f699effadcbe378b6a746d77ccdbd

SUMMARY = "A sophisticated Numeric Processing Package for Python"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause & BSD-2-Clause & PSF & Apache-2.0 & BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d26bde5432613cce2334b93985576231"

SRCNAME = "numpy"

SRC_URI = "https://github.com/${SRCNAME}/${SRCNAME}/releases/download/v${PV}/${SRCNAME}-${PV}.tar.gz \
           file://0001-Don-t-search-usr-and-so-on-for-libraries-by-default-.patch \
           file://0001-npy_cpu-Add-riscv-support.patch \
           ${CONFIGFILESURI} \
           "
SRC_URI[md5sum] = "0886e5b5017f08f2b7a624c0b5931e61"
SRC_URI[sha256sum] = "adf063a3f87ab89393f5eea0eb903293b112fa0a308e8c594a75ffa585d81d4f"

UPSTREAM_CHECK_URI = "https://github.com/numpy/numpy/releases"
UPSTREAM_CHECK_REGEX = "(?P<pver>\d+(\.\d+)+)\.tar"

inherit ${@bb.utils.contains("BBFILE_COLLECTIONS", "meta-python2", "setuptools", "", d)}

python() {
    if 'meta-python2' not in d.getVar('BBFILE_COLLECTIONS').split():
        raise bb.parse.SkipRecipe('Requires meta-python2 to be present.')
}

CONFIGFILESURI ?= ""

CONFIGFILESURI:aarch64 = " \
    file://config.h \
    file://_numpyconfig.h \
"
CONFIGFILESURI:arm = " \
    file://config.h \
    file://numpyconfig.h \
"
CONFIGFILESURI:armeb = " \
    file://config.h \
    file://numpyconfig.h \
"
CONFIGFILESURI:mipsarcho32el = " \
    file://config.h \
    file://numpyconfig.h \
"
CONFIGFILESURI:x86 = " \
    file://config.h \
    file://numpyconfig.h \
"
CONFIGFILESURI:x86-64 = " \
    file://config.h \
    file://_numpyconfig.h \
"
CONFIGFILESURI:mipsarcho32eb = " \
    file://config.h \
    file://_numpyconfig.h \
"
CONFIGFILESURI:powerpc = " \
    file://config.h \
    file://_numpyconfig.h \
"
CONFIGFILESURI:powerpc64 = " \
    file://config.h \
    file://_numpyconfig.h \
"
CONFIGFILESURI:mipsarchn64eb = " \
    file://config.h \
    file://_numpyconfig.h \
"
CONFIGFILESURI:mipsarchn64el = " \
    file://config.h \
    file://_numpyconfig.h \
"
CONFIGFILESURI:mipsarchn32eb = " \
    file://config.h \
    file://_numpyconfig.h \
"
CONFIGFILESURI:mipsarchn32el = " \
    file://config.h \
    file://_numpyconfig.h \
"
CONFIGFILESURI:riscv64 = " \
    file://config.h \
    file://_numpyconfig.h \
"

S = "${WORKDIR}/numpy-${PV}"

CLEANBROKEN = "1"

# Make the build fail and replace *config.h with proper one
# This is a ugly, ugly hack - Koen
do_compile:prepend:class-target() {
    ${STAGING_BINDIR_NATIVE}/${PYTHON_PN}-native/${PYTHON_PN} setup.py build ${DISTUTILS_BUILD_ARGS} || \
    true
    cp ${WORKDIR}/*config.h ${S}/build/$(ls ${S}/build | grep src)/numpy/core/include/numpy/
}

FILES:${PN}-staticdev += "${PYTHON_SITEPACKAGES_DIR}/numpy/core/lib/*.a"

# install what is needed for numpy.test()
RDEPENDS:${PN} = "${PYTHON_PN}-unittest \
                  ${PYTHON_PN}-difflib \
                  ${PYTHON_PN}-pprint \
                  ${PYTHON_PN}-pickle \
                  ${PYTHON_PN}-shell \
                  ${PYTHON_PN}-nose \
                  ${PYTHON_PN}-doctest \
                  ${PYTHON_PN}-datetime \
                  ${PYTHON_PN}-distutils \
                  ${PYTHON_PN}-misc \
                  ${PYTHON_PN}-mmap \
                  ${PYTHON_PN}-netclient \
                  ${PYTHON_PN}-numbers \
                  ${PYTHON_PN}-pydoc \
                  ${PYTHON_PN}-pkgutil \
                  ${PYTHON_PN}-email \
                  ${PYTHON_PN}-compression \
                  ${PYTHON_PN}-ctypes \
                  ${PYTHON_PN}-threading \
"

RDEPENDS:${PN}:class-native = ""

BBCLASSEXTEND = "native nativesdk"

RDEPENDS:${PN}:class-target:append = " \
    ${PYTHON_PN}-subprocess \
"

do_install:append(){
    rm ${D}/${bindir}/f2py
}
