# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   website/license.rst
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "BSD-3-Clause & Unknown"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=0f34c2a8b1c102d683feca7a5835e921"

SRC_URI = "git://github.com/AcademySoftwareFoundation/Imath.git;protocol=https;branch=main"

# Modify these as desired
PV = "3.1.9+git${SRCPV}"
SRCREV = "642312b48e4c054198a3887b9e4e53da08fb7531"

S = "${WORKDIR}/git"

# NOTE: unable to map the following CMake package dependencies: Python2 Python3 Sphinx Doxygen pybind11 Python Imath
DEPENDS = " \
   boost \
   python3-pybind11 \
"

inherit cmake python3native

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

