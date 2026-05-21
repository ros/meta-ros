FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI += "file://0001-remove-opt-projectname-install-prefix.patch"
ROS_BUILDTOOL_EXPORT_DEPENDS:remove = "python3-vcstool-native"
ROS_BUILDTOOL_EXPORT_DEPENDS:append = " python3-vcs2l-native"
