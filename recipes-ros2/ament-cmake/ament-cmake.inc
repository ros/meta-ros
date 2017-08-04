HOMEPAGE = "https://github.com/ament/ament_cmake"

SRCREV = "dc243d84429ccefbe3532c59a242a114eb20bad6"
SRC_URI = "git://github.com/ament/ament_cmake.git;protocol=git;"

inherit cmake python3native

ROS_BPN = "${@d.getVar('BPN', True).replace('-', '_')}"

S = "${WORKDIR}/git/${ROS_BPN}"

do_install_append() {
    rm -f ${D}${datadir}/${ROS_BPN}/local_setup.bash
    rm -f ${D}${datadir}/${ROS_BPN}/local_setup.sh
    rm -f ${D}${datadir}/${ROS_BPN}/local_setup.zsh
}

FILES_${PN} += "${datadir}"

BBCLASSEXTEND += "native"
