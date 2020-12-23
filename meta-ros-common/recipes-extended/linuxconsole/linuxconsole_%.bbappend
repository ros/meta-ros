PROVIDES += "joystick"

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
