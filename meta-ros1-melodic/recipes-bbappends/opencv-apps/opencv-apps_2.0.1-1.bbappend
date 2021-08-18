# Copyright (c) 2020-2021 LG Electronics, Inc.

# Rename PN to PN-ros, because
# meta-ros1-melodic/recipes-support/opencv/opencv_3.4.5.bb
# has package name PN-apps which conflicts with this recipe
PACKAGES:remove = "${PN}"
PACKAGE_BEFORE_PN = "${PN}-ros"
FILES:${PN}-ros = "${FILES:opencv-apps}"

# ros_opt_prefix.bbclass already sets this for ${PN} and ${PN}-dbg, but we now need it for ${PN}-ros as well
INSANE_SKIP:${PN}-ros += "libdir"
