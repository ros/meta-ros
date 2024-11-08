# Copyright (c) 2024 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI = " \
    git://github.com/Fields2Cover/fields2cover-release;name=release;${ROS_BRANCH};protocol=https \
    git://github.com/Fields2Cover/steering_functions.git;protocol=https;name=steering-functions;destsuffix=git/steering_functions;branch=master \
    git://github.com/Fields2Cover/spline.git;protocol=https;name=spline;destsuffix=git/spline;branch=master \
    git://github.com/Fields2Cover/matplotlib-cpp.git;protocol=https;name=matplotlib-cpp;destsuffix=git/matplotlib-cpp;branch=master \
    file://cmakelists-use-system-libraries.patch \
    file://use-bitbake-fetcher.patch \
"

SRCREV_release = "2999def538cf52b4aaec294dc7171234baf94ae5"
SRCREV_steering-functions = "33fc010017efa1ef2c8a2d4779fcda94b4b30d20"
SRCREV_spline = "1b5d4bad29082997076b264de84ca6d46c2ae6ab"
SRCREV_matplotlib-cpp = "75c15d0c907a4b68bca5ef97032302bd14ccab8e"

SRCREV_FORMAT = "release_steering-functions_spline_matplotlib-cpp"

ROS_BUILD_DEPENDS += " \
    boost \
    gdal \
    geos \
    libtinyxml2 \
    nlohmann-json \
"

inherit python3native

FILES:${PN} += " \
    ${datadir}/Fields2Cover/package.xml \
"

EXTRA_OECMAKE += "-DINSTALL_CMAKE_DIR=${baselib}"
