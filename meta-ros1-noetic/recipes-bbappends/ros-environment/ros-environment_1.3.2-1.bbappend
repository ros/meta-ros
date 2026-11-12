# Copyright (c) 2019 LG Electronics, Inc.

EXTRA_OECMAKE:append = " -DCMAKE_POLICY_VERSION_MINIMUM=3.5"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI:append = " \
    file://add-vars.patch \
"

do_configure:prepend:class-target() {
    sed -i -e 's,@(PYTHON_EXECUTABLE),${bindir}/env python${ROS_PYTHON_VERSION},' ${S}/env-hooks/1.ros_package_path.sh.em
}
