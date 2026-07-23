DESCRIPTION = "Command line tools for working with catkin"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=10;endline=10;md5=9a6ea5b6c346a830f54cc95f6a2a9245"
PYPI_PACKAGE = "catkin_tools"

SRC_URI[sha256sum] = "2de860e29778064b5f06f32202a667665654269ad70ea95f7ab54741fae57794"

inherit setuptools3
inherit pypi

# /usr/share/zsh/site-functions/_catkin
FILES:${PN} += "\
    ${datadir}/zsh \
    ${datadir}/bash-completion/completions/catkin.bash \
"

BBCLASSEXTEND = "native nativesdk"
