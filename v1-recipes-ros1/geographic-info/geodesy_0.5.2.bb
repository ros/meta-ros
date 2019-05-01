DESCRIPTION = "Python and C++ interfaces for manipulating geodetic coordinates."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "tf geographic-msgs unique-id"
RDEPENDS_${PN} = "python-pyproj tf geographic-msgs unique-id"

require geographic-info.inc
