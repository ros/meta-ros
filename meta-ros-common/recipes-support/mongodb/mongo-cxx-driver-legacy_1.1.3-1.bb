LICENSE = "Apache-2.0 & Zlib & BSD-3-Clause & MIT"
LIC_FILES_CHKSUM = "file://APACHE-2.0.txt;md5=3b83ef96387f14655fc854ddc3c6bd57 \
                    file://THIRD-PARTY-NOTICES;md5=f5e9031fc85d11004366eb2ceba66306 \
                    file://debian/copyright;md5=d0ec59a33bf93f1e2dd7c0688c0cccbc \
                    file://src/third_party/gtest-1.7.0/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://src/third_party/restclient/LICENSE;md5=875d6e9ec1cb59099f4d9da1e81d1e91"

SRC_URI = "git://salsa.debian.org/mongodb-team/mongo-cxx-driver-legacy.git;protocol=https;branch=debian \
    file://Add-octal-prefix-to-umask.patch \
    file://Use-Python3-queue.patch \
    file://Open-generated-files-as-text.patch \
    file://Fix-import-of-modules-in-same-directory.patch \
    file://Remove-reference-to-urllib2.patch \
    file://Use-PATH-envvar.patch \
    file://Fix-python-syntax.patch \
    file://1001_set_soname.patch \
    file://1002_openssl_1.1_compat.patch \
    file://1003_C++11_compat.patch \
    file://1004_fix_ftbfs_with_gcc6.1.patch \
    file://2001_use_system_libraries_if_possible.patch \
    file://2002_add-latomic-for-mips32.patch \
    file://boost-1.67-compat.patch \
"

SRCREV = "f007ec261210eb1495838fc0522666b4302e0583"
S = "${WORKDIR}/git"

inherit python3native

DEPENDS += " \
    boost \
    python3-scons-native \
"

EXTRA_OESCONS = " \
    --prefix="${prefix}" \
    --build-dir="${B}" \
    --directory="${S}" \
    --install-sandbox="${D}" \
    --cxx-use-shell-environment \
    --cc-use-shell-environment \
    CFLAGS="${CFLAGS}" \
    CXXFLAGS="${CXXFLAGS}" \
    LINKFLAGS="${LDFLAGS}" \
"

# time_support.cpp:198:49: error: 'snprintf' output may be truncated before the last format character [-Werror=format-truncation=]
CXXFLAGS += "-Wno-error=format-truncation"
# assert_util.h:231:28: error: 'nonnull' argument 'this' compared to NULL [-Werror=nonnull-compare]
CXXFLAGS += "-Wno-error=nonnull-compare"

do_configure() {
    if [ -n "${CONFIGURESTAMPFILE}" -a "${S}" = "${B}" ]; then
        if [ -e "${CONFIGURESTAMPFILE}" -a "`cat ${CONFIGURESTAMPFILE}`" != "${BB_TASKHASH}" -a "${CLEANBROKEN}" != "1" ]; then
            ${STAGING_BINDIR_NATIVE}/scons --clean ${EXTRA_OESCONS}
        fi

        mkdir -p `dirname ${CONFIGURESTAMPFILE}`
        echo ${BB_TASKHASH} > ${CONFIGURESTAMPFILE}
    fi
}

do_compile() {
    ${STAGING_BINDIR_NATIVE}/scons ${PARALLEL_MAKE} ${EXTRA_OESCONS} || \
    die "scons build execution failed."
}

do_install() {
    ${STAGING_BINDIR_NATIVE}/scons ${EXTRA_OESCONS} install || \
    die "scons install execution failed."
}

FILES:${PN}-dev += "${includedir}/mango"
