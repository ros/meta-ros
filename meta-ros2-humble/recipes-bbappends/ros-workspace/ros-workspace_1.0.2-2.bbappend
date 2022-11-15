FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI:append = " \
    file://0001-CMakeLists-Fix-Cross-Compile.patch \
"

ROS_BUILD_DEPENDS:remove = " \
    ament-cmake-core \
    ament-package \
"

ROS_BUILDTOOL_DEPENDS += " \
    ament-cmake-core-native \
    ament-package-native \
"

EXTRA_OECMAKE += " \
    -DCMAKE_PREFIX_PATH=${STAGING_DIR_NATIVE}/usr \
"