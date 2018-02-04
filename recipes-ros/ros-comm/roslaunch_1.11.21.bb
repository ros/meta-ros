DESCRIPTION = "roslaunch is a tool for easily launching multiple ROS nodes locally and remotely \
via SSH, as well as setting parameters on the Parameter Server."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=d566ef916e9dedc494f5f793a6690ba5"

PR = "r1"

require ros-comm.inc

SRC_URI += "file://0001-increase-rosmaster-timeout.patch \
    file://roscore.service \
    file://roscore-default \
"

ROS_PKG_SUBDIR = "tools"

RDEPENDS_${PN} = "\
    ${@'python-textutils' if d.getVar('PYTHON_PN', True) == 'python2' else ''} \
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-threading \
    ${PYTHON_PN}-rospkg \
    rosgraph \
    ${PYTHON_PN}-pyyaml \
    roslib \
    rosclean \
    rosmaster \
    rosgraph-msgs \
    genpy \
    std-msgs \
    rosout \
    rosparam \
"

do_install_append() {
    install -d ${D}/${sysconfdir}/default
    install -m 0644 ${WORKDIR}/roscore-default ${D}/${sysconfdir}/default/roscore

    # Install systemd unit file
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/roscore.service ${D}${systemd_unitdir}/system/roscore.service
}

FILES_${PN}-systemd += "${sysconfdir}/default/roscore \
"

CONFFILES_${PN}-systemd += "${sysconfdir}/default/roscore \
"

inherit systemd
PACKAGES += "${PN}-systemd"
SYSTEMD_PACKAGES = "${PN}-systemd"
SYSTEMD_SERVICE = "roscore.service \
"
