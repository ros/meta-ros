HOMEPAGE = "https://github.com/dartsim/dart"
LICENSE = "BSD-2-Clause & BSD-3-Clause & MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f9c9b64e6293fa51cd808f54fa1733d9 \
                    file://data/mjcf/openai/LICENSE.md;md5=b7fcc920c21836f90e2ba40fd8fad0a7"

SRC_URI = "git://github.com/dartsim/dart.git;protocol=https;branch=release-6.14 \
           file://python3-fixes.patch \
           file://fix-pkgconfig-cflags.patch \
           file://remove-buildpath.patch \
           file://set-dart-pkgconfig-deps-to-eigen3.patch \
"

SRCREV = "a51e08c210d7892605c6dc0b9ae96fce4446d9fe"

S = "${WORKDIR}/git"

DEPENDS = " \
    assimp \
    bullet \
    doxygen-native \
    fmt-native \
    fcl \
    google-benchmark \
    libccd \
    libeigen \
    libtinyxml2 \
    ipopt \
    nlopt \
    octomap \
    ode \
    openscenegraph \
    pagmo \
    python3-requests \
    python3-pytest \
    urdfdom \
    urdfdom-headers \
    virtual/libgl \
"


inherit setuptools3 cmake pkgconfig

inherit ros_opt_prefix
EXTRA_OECMAKE:prepend = "\
    -DCMAKE_PREFIX_PATH='${STAGING_DIR_HOST}${ros_prefix};${STAGING_DIR_HOST}${prefix}' \
    -DDART_ENABLE_SIMD=OFF \
"

CXXFLAGS += "-Wno-error=deprecated-copy -Wno-error=reorder"

FILES:${PN} += "${datadir}/dart"

# ERROR: dartsim-6.13.2-r0 do_package_qa: QA Issue: File ... in package dartsim doesn't have GNU_HASH (didn't pass LDFLAGS?)
INSANE_SKIP:${PN} += "ldflags"
