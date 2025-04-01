do_configure[network] = "1"

DEPENDS += " \
    curl \
"

ROS_BUILDTOOL_DEPENDS += " \
    pkgconfig-native \
"

EXTRA_OECMAKE += " \
    -DBUILD_TESTS=OFF \
    -DBUILD_EXAMPLES=OFF \
    -DBUILD_UNIT_TESTS=OFF \
    -DBUILD_PYTHON_BINDINGS=OFF \
    -DBUILD_SHARED_LIBS=ON \
    -DBUILD_TOOLS=OFF \
    -DCHECK_FOR_UPDATES=OFF \
    -DBUILD_WITH_DDS=OFF \
"

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package librealsense2 contains symlink .so '/usr/lib/librealsense2.so' [dev-so]
FILES:${PN}-dev += "${ros_libdir}/librealsense2.so"
