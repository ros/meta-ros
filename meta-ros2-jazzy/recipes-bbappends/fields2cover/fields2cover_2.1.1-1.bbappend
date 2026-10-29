# Copyright (c) 2024 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI = " \
    git://github.com/Fields2Cover/fields2cover-release;name=release;${ROS_BRANCH};protocol=https \
    git://github.com/Fields2Cover/steering_functions.git;protocol=https;name=steering-functions;destsuffix=git/steering_functions;branch=master \
    git://github.com/Fields2Cover/spline.git;protocol=https;name=spline;destsuffix=git/spline;branch=master \
    git://github.com/Fields2Cover/matplotlib-cpp.git;protocol=https;name=matplotlib-cpp;destsuffix=git/matplotlib-cpp;branch=master \
    file://use-bitbake-fetcher.patch \
"
NOT_INCLUDED = " \
    file://fields2cover_CMakeLists.patch \
    file://matplotlib-cpp_CMakeLists.patch;patchdir=matplotlib-cpp \
    file://spline_CMakeLists.patch;patchdir=spline \
"

SRCREV_release = "af777ee262a5b88175dc637fab7a389f3979e0f1"
SRCREV_steering-functions = "33fc010017efa1ef2c8a2d4779fcda94b4b30d20"
SRCREV_spline = "1b5d4bad29082997076b264de84ca6d46c2ae6ab"
SRCREV_matplotlib-cpp = "75c15d0c907a4b68bca5ef97032302bd14ccab8e"

SRCREV_FORMAT = "release_steering-functions_spline_matplotlib-cpp"

ROS_BUILD_DEPENDS:remove = "gtest"
ROS_EXPORT_DEPENDS:remove = "gtest"
ROS_EXEC_DEPENDS:remove = "gtest"
ROS_TEST_DEPENDS:remove = "gtest"

ROS_BUILD_DEPENDS += " \
    boost \
    gdal \
    geos \
    googletest \
    libtinyxml2 \
    nlohmann-json \
    tinyxml2-vendor \
"

inherit python3native

FILES:${PN} += " \
    ${datadir}/Fields2Cover/package.xml \
"

# In constructor 'matplotlibcpp::detail::_interpreter::_interpreter()':
# error: 'void Py_SetProgramName(const wchar_t*)' is deprecated [-Werror=deprecated-declarations]
CXXFLAGS += "-Wno-error=deprecated-declarations"

# In function 'OGRPoint f2c::types::operator+(const OGRPoint&, const Point&)':
# error: moving a temporary object prevents copy elision [-Werror=pessimizing-move]
CXXFLAGS += "-Wno-error=pessimizing-move"

EXTRA_OECMAKE += "-DINSTALL_CMAKE_DIR=${baselib}"

do_install:append() {
    # Fix for QA warning [buildpaths]
    sed -i -e "s#${S}/matplotlib-cpp/#${includedir}#g" ${D}${libdir}/cmake/matplotlib_cpp/matplotlib_cppConfig.cmake
    sed -i -e "s#${S}/spline#${includedir}#g" ${D}${libdir}/cmake/spline/splineConfig.cmake
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${libdir}/cmake/fields2cover/Fields2Cover-shared-Targets.cmake
}
