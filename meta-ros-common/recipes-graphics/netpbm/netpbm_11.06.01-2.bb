# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   converter/other/cameratopam/COPYRIGHT
#   converter/other/pnmtopalm/LICENSE
#   converter/pbm/pbmtoppa/LICENSE
#   converter/ppm/ppmtompeg/COPYRIGHT
#   debian/copyright
#   doc/COPYRIGHT.PATENT
#   doc/GPL_LICENSE.txt
#   doc/copyright_summary
#   lib/util/LICENSE.txt
#   other/pamx/COPYRIGHT
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "GPL-2.0-only & Unknown"
LIC_FILES_CHKSUM = "file://converter/other/cameratopam/COPYRIGHT;md5=b599b5fdcb221af54d1ae96023826a79 \
                    file://converter/other/jbig/libjbig/COPYING;md5=8ca43cbc842c2336e835926c2166c28b \
                    file://converter/other/pnmtopalm/LICENSE;md5=6d644cf37a0fd379433b17c0fefc4c32 \
                    file://converter/pbm/pbmtoppa/LICENSE;md5=e6d8a8731b55aec86c981b6474ff0888 \
                    file://converter/ppm/ppmtompeg/COPYRIGHT;md5=524ff2e7d68c9b2b9be44fa6dc43b6a9 \
                    file://debian/copyright;md5=a24beed3902a60139f7b19bba9f25017 \
                    file://doc/COPYRIGHT.PATENT;md5=34528ea0c5550dc4920c69ccc66ea270 \
                    file://doc/GPL_LICENSE.txt;md5=079b27cd65c86dbc1b6997ffde902735 \
                    file://doc/copyright_summary;md5=6bb45eba960ba79396647dd8925de8b6 \
                    file://lib/util/LICENSE.txt;md5=e1f509120273e76ee43e03137569b11e \
                    file://other/pamx/COPYRIGHT;md5=70075b407c887a3c57e794e2dbffeb1b"

SRC_URI = "git://salsa.debian.org/debian-phototools-team/netpbm.git;protocol=https;branch=master"

# Modify these as desired
PV = "11.06.01-2+git"
SRCREV = "c3658694ae3179142edc504497a36f8f3d62aa28"

S = "${WORKDIR}/git"

# NOTE: some of these dependencies may be optional, check the Makefile and/or upstream documentation
DEPENDS = "flex-native libx11"

# NOTE: this is a Makefile-only piece of software, so we cannot generate much of the
# recipe automatically - you will need to examine the Makefile yourself and ensure
# that the appropriate arguments are passed in.

do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# You will almost certainly need to add additional arguments here
	oe_runmake
}

do_install () {
	# NOTE: unable to determine what to put here - there is a Makefile but no
	# target named "install", so you will need to define this yourself
	:
}

