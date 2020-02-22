DESCRIPTION = "Linux Console tools, which include utilities to test and configure joysticks, connect legacy devices to the kernel's input subsystem (providing support for serial mice, touchscreens etc.), and test the input event layer."

LICENSE = "GPL-2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "${SOURCEFORGE_MIRROR}/linuxconsole/linuxconsoletools-${PV}.tar.bz2"
SRC_URI[md5sum] = "d6d470394984489855ce839d045aa5eb"
SRC_URI[sha256sum] = "e9d6b05a6c57c7eb3ec7f9f017f46b20e4b55d5a02f930eff1823a13921c5934"

S = "${WORKDIR}/linuxconsoletools-${PV}"

do_compile_prepend() {
    # drop ffmvforce so that we don't need libsdl
    sed '/^PROGRAMS/s/ffmvforce *//g' -i ${S}/utils/Makefile
    # respect nonarch_base_libdir path to keep QA check happy
    sed 's#DESTDIR)/lib/udev#DESTDIR)/${nonarch_base_libdir}/udev#g' -i ${S}/utils/Makefile
}

do_install() {
    oe_runmake install DESTDIR=${D} PREFIX=${prefix}
}

PACKAGES =+ "${PN}-jscal"

FILES_${PN}-jscal = " \
    ${datadir}/joystick \
    ${bindir}/jscal-restore \
    ${bindir}/jscal-store \
"

# ERROR: joystick-1.6.1-r0 do_package_qa: QA Issue: joystick-jscal rdepends on bash, but it isnt a build dependency, missing bash in DEPENDS or PACKAGECONFIG? [build-deps]
RDEPENDS_${PN}-jscal = "bash busybox gawk"

# This is needed only for webOS OSE, which uses busybox to provide
# bash by default, but with newer OSE this should respect
# WEBOS_PREFERRED_PROVIDER_FOR_BASH and it's not in meta-ros-webos, because
# then meta-ros-webos would need to include this .bbappend just when
# meta-ros2-dashing layer is included
VIRTUAL-RUNTIME_bash ?= "bash"
RDEPENDS_${PN}-jscal_append_class-target_webos = " ${VIRTUAL-RUNTIME_bash}"
RDEPENDS_${PN}-jscal_remove_class-target_webos = "${@oe.utils.conditional('WEBOS_PREFERRED_PROVIDER_FOR_BASH', 'busybox', 'bash', '', d)}"
