DESCRIPTION = "Package modeling the build-time dependencies for generating language bindings of messages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros-gbp/message_generation-release/archive/release/message_generation/0.2.9.tar.gz;downloadfilename=message-generation_0.2.9.tar.gz"
SRC_URI[md5sum] = "9458c88437cb9bc3f3b70dd4d67bf1f3"
SRC_URI[sha256sum] = "c474649944ec01ad2df80dc2674d235705771cd9a9cf3794fc9490b5fe9c0d5e"

S = "${WORKDIR}/message_generation-release-release-message_generation-0.2.9"

DEPENDS = "catkin-native gencpp"

FILES_${PN} += "${libdir}/*"

inherit cmake pythonnative

EXTRA_OECMAKE = " \
  -Dgencpp_DIR=${STAGING_DATADIR}/gencpp/cmake/ \
  "
