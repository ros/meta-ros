# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

ROS_BUILD_DEPENDS:remove = "ament-cmake-core"
ROS_BUILD_DEPENDS:remove = "ament-package"
ROS_BUILDTOOL_DEPENDS += " \
    ament-cmake-core-native \
    ament-package-native \
"

# The package find files from CMAKE_INSTALL_PREFIX that is just absolute "/usr".
# Need to pass the native sysroot folder path.
export STAGING_DIR_NATIVE
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI:append = " file://0001-Don-t-use-CMAKE_INSTALL_PREFIX-as-sysroot-for-cross-.patch"


# ERROR: ros-workspace-1.0.2-1-r0 do_package: QA Issue: ros-workspace: Files/directories were installed but not shipped in any package:
#   /usr/setup.sh
#   /usr/setup.zsh
#   /usr/local_setup.bash
#   /usr/local_setup.zsh
#   /usr/setup.bash
#   /usr/local_setup.sh
#   /usr/_local_setup_util.py
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# ros-workspace: 7 installed and not shipped files. [installed-vs-shipped]
do_install:append() {
    rm -r ${D}/usr/setup.sh
    rm -r ${D}/usr/setup.zsh
    rm -r ${D}/usr/local_setup.bash
    rm -r ${D}/usr/local_setup.zsh
    rm -r ${D}/usr/setup.bash
    rm -r ${D}/usr/local_setup.sh
    rm -r ${D}/usr/_local_setup_util.py
}
