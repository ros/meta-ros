# Copyright (c) 2019-2020 LG Electronics, Inc.

# The cmake subdirectory isn't under datadir/ROS_BPN. In fact, there are two.
FILES:${PN}-dev:prepend = " \
    ${libdir}/cmake/${ROS_BPN} \
    ${libdir}/BehaviorTree/cmake \
"

do_install:append() {
    rm -f ${D}${libdir}/pkgconfig/tinyxml2.pc
    rmdir -p --ignore-fail-on-non-empty ${D}${libdir}/pkgconfig || true
}
