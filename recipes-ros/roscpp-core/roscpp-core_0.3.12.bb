DESCRIPTION = "Underlying data libraries for roscpp messages"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros-gbp/roscpp_core-release/archive/release/roscpp_core/0.3.12.tar.gz;downloadfilename=roscpp-cppcore_0.3.12.tar.gz"
SRC_URI[md5sum] = "56cfd5b11cba6d28f742106a1eeafc92"
SRC_URI[sha256sum] = "b9ed9dadb21430deb87d56f4051da80238a36feea972ec0d3cecbfe91bb42d84"

S = "${WORKDIR}/roscpp_core-release-release-roscpp_core-0.3.12"

ALLOW_EMPTY = "1"

DEPENDS = "\
  cpp-common \
  roscpp-serialization \
  roscpp-traits \
  rostime \
"

FILES_${PN} = ""
FILES_${PN}-dev = ""

