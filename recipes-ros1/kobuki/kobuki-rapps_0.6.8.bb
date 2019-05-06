DESCRIPTION = "Robot apps for Kobuki"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

require kobuki.inc

RDEPENDS_${PN} = "kobuki-auto-docking kobuki-random-walker nodelet"
