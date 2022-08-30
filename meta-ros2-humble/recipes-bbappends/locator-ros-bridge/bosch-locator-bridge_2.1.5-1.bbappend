ROS_BUILDTOOL_DEPENDS:append = " \
    rosidl-default-generators-native \
"

ROS_BUILD_DEPENDS:remove = " \
    sensor-msgs \
    rosidl-default-generators \
    qhull \
"

# patch from upstream
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI:append = " \
    file://0001-Add-missing-dependencies.patch \
"