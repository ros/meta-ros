HOMEPAGE = "https://github.com/dartsim/dart"
LICENSE = "BSD-2-Clause & BSD-3-Clause & MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a89a91ad8b0e80a94a412a7a37b5b492 \
                    file://data/mjcf/openai/LICENSE.md;md5=b7fcc920c21836f90e2ba40fd8fad0a7"

SRC_URI = "git://github.com/dartsim/dart.git;protocol=https;branch=release-6.14 \
           file://python3-fixes.patch \
           file://use-system-googletest.patch \
           file://use-system-pybind11.patch \
           file://fix-pkgconfig-cflags.patch \
           file://remove-buildpath.patch \
"

SRCREV = "2b6abb557652fe4eb7f80a7be52706d7ca20cf86"

S = "${WORKDIR}/git"

DEPENDS = " \
    assimp \
    bullet \
    doxygen-native \
    fmt-native \
    fcl \
    google-benchmark \
    googletest-native \
    libccd \
    libeigen \
    libtinyxml2 \
    ipopt \
    nlopt \
    octomap \
    ode \
    openscenegraph \
    pagmo \
    python3-pybind11 \
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
