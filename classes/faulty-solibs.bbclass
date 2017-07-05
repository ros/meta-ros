# Ideally, the software packages upstream should be fixed to provide dynamic
# libraries with version number and symlinks without version number to them.
# This class sets up bitbake to handle improper set up software packages.
FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/lib*${SOLIBSDEV}"
