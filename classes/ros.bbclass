#
# Copyright (c) 2013 Stefan Herbrechtsmeier, Bielefeld University
# 

ROS_BPN = "${@d.getVar('BPN', True).replace('-', '_')}"
ROS_BP = "${ROS_BPN}-${PV}"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/lib*${SOLIBSDEV}"

FILES_${PN} += "\
    ${prefix}/etc \
    ${datadir}/ros/config/${ROS_BPN}.config \
    ${datadir}/${ROS_BPN} \
    "

FILES_${PN}-dev += "\
    ${datadir}/${ROS_BPN}/cmake \
    ${datadir}/${ROS_BPN}/*.template \
    "

FILES_${PN}-dbg += "\
    ${libdir}/${ROS_BPN}/.debug/* \
    "

PACKAGES += "${PN}-commonlisp"

FILES_${PN}-commonlisp += " \
    ${datadir}/common-lisp/ \
    "
