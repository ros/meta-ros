# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7eb60e29c1b7d33cea477b84618c2f4d"

SRC_URI = "git://github.com/gazebosim/gz-fortress.git;protocol=https;branch=main"

# Modify these as desired
PV = "1.0.3+git${SRCPV}"
SRCREV = "a8b194cb334944458b698f6d4d01b13b63c25f1d"

S = "${WORKDIR}/git"

inherit cmake

DEPENDS = " \
    ignition-cmake2 \
    ignition-common4 \
    ignition-fuel-tools7 \
    ignition-gazebo6 \
    ignition-gui6 \
    ignition-launch5 \
    ignition-math6 \
    ignition-msgs8 \
    ignition-physics5 \
    ignition-plugin \
    ignition-rendering6 \
    ignition-sensors6 \
    ignition-transport11 \
    ignition-utils1 \
    sdformat \
"
# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

