LICENSE = "BSD-3-Clause"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Use-cmake-Thread-package-to-find-proper-threading-li.patch"

# Remove some dependencies we do not need:
DEPENDS:remove = "${ROS_UNRESOLVED_DEP-libopenni-dev} libfreenect qt-gui-cpp qtbase"
RDEPENDS:${PN}:remove = "${ROS_UNRESOLVED_DEP-libopenni-dev} libfreenect qt-gui-cpp qtbase"

# the native package only builds the res-tool
DEPENDS:remove:class-native = "octomap libg2o cv-bridge pcl proj"
RDEPENDS:${PN}:remove:class-native = "octomap libg2o cv-bridge pcl proj"

# When we build for the target, we require a native build
DEPENDS:append:class-target = " ${BPN}-native"

# only build res-tool for native variant
OECMAKE_TARGET_COMPILE:class-native = "res_tool"

# Define was removed from PCL library in version 1.10:
CXXFLAGS += "-DDISABLE_VTK"

# Build without Qt, examples and tools
# Build as release
EXTRA_OECMAKE += " \
    -DBUILD_TOOLS=OFF \
    -DBUILD_EXAMPLES=OFF \
    -DWITH_QT=OFF \
    -DWITH_FREENECT=OFF \
    -DWITH_FREENECT2=OFF \
    -DCMAKE_BUILD_TYPE=Release \
    -DCOMPILER_SUPPORTS_CXX17=ON \
"

EXTRA_OECMAKE:class-native += " \
    -DUNIX=ON \
    -DANDROID_PREBUILD=ON \
"

export LD_LIBRARY_PATH = "${RECIPE_SYSROOT_NATIVE}/${ros_libdir}"

# ERROR: rtabmap-0.21.5-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package rtabmap contains symlink .so '/opt/ros/rolling/lib/librtabmap_core.so' [dev-so]
# ERROR: rtabmap-0.21.5-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package rtabmap contains symlink .so '/opt/ros/rolling/lib/librtabmap_utilite.so' [dev-so]
# Undo ros_faulty_solibs and include uncommon cmake config path:
FILES:${PN}-dev += " \
    ${ros_libdir}/${PN}-0.20/ \
    ${ros_libdir}/lib*${SOLIBSDEV} \
"

# ERROR: rtabmap-0.21.5-1-r0 do_package_qa: QA Issue: File /opt/ros/rolling/lib/rtabmap-0.21/RTABMap_coreTargets.cmake in package rtabmap contains reference to TMPDIR [buildpaths]
do_install:append:class-target() {
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_libdir}/rtabmap-0.21/RTABMap_coreTargets.cmake
}

BBCLASSEXTEND = "native"
