FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI:append = " \
    file://0001-CMakeLists-Update-ROS_DISTRO-version-to-humble.patch \
    "
