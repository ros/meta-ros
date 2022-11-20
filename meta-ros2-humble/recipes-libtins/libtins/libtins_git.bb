# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dcaaaf1a01e7f9ceb200d383a0d4320c \
"
SRC_URI = "git://github.com/mfontanini/libtins.git;protocol=https;branch=master"

# Modify these as desired
PV = "4.4+git${SRCPV}"
SRCREV = "e3aedc56edc7e9f39170c195de9a886a4309b0cb"

S = "${WORKDIR}/git"


DEPENDS = "openssl boost libpcap"

inherit cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = "-DBUILD_TESTING=OFF"

