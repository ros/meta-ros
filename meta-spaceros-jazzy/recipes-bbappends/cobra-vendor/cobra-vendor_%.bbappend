ROS_BUILD_DEPENDS += "cobra"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://use-system-cobra.patch"
