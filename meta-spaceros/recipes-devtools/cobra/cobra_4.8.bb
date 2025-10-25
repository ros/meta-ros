# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   doc/License
#   src/License
LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://doc/License;md5=8c40b6377ed6920e877be2267e3daaf3 \
                    file://src/License;md5=8c40b6377ed6920e877be2267e3daaf3"

SRC_URI = "git://github.com/nimble-code/Cobra.git;protocol=https;branch=master"

# Modify these as desired
PV = "4.8+git"
SRCREV = "5af7230ecf29a6c9b46ff1bdd60c5d9e51d032db"

S = "${WORKDIR}/git"

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

