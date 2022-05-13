
# Apply patches
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-Use-cmake-Thread-package-to-find-proper-threading-li.patch \
    file://0002-Make-res_tool-an-imported-target-when-cross-compilin.patch \
    "

# Remove some dependencies we do not need:
DEPENDS:remove = "${ROS_UNRESOLVED_DEP-libopenni-dev} libfreenect qt-gui-cpp"
RDEPENDS:${PN}:remove = "${ROS_UNRESOLVED_DEP-libopenni-dev} libfreenect qt-gui-cpp"

# the native package only builds the res-tool
DEPENDS:remove:class-native = "octomap libg2o cv-bridge pcl proj"
RDEPENDS:${PN}:remove:class-native = "octomap libg2o cv-bridge pcl proj"

# When we build for the target, we require a native build
DEPENDS:append:class-target = " ${BPN}-native"

BBCLASSEXTEND="native"

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
"

EXTRA_OECMAKE:class-native += " \
    -DUNIX=ON \
    -DANDROID_PREBUILD=ON \
"

# Undo ros_faulty_solibs and include uncommon cmake config path:
FILES:${PN}-dev += " \
    ${libdir}/${PN}-0.20/ \
    ${libdir}/lib*${SOLIBSDEV} \
"
