# The transforms3d python package is a runtime dependency.
# It's probably missing from the package.xml dependencies list.
RDEPENDS:${PN}:append = " python3-transforms3d"
