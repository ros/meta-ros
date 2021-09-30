DESCRIPTION = "The COLLADA Document Object Model (DOM) is an application \
programming interface (API) that provides a C++ object representation of a \
COLLADA XML instance document." 
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://License_Folder/license_e.txt;md5=33ea5b7341abf67bd9055a229646feae"

DEPENDS = "boost libxml2 libpcre"

SRC_URI = "${SOURCEFORGE_MIRROR}/${BPN}/${BP}.tgz \
           file://0001-Fix-return-value-to-be-of-expected-type.patch \
           "
SRC_URI[md5sum] = "20399de4206eab850c32e65c04e907cb"
SRC_URI[sha256sum] = "5ca2d12f744bdceff0066ed3067b3b23d6859581fb0d657f98ba4487d8fa3896"

EXTRA_OECMAKE += "\
  -DCMAKE_SKIP_RPATH=ON \
"

inherit cmake pkgconfig

FILES:${PN}-dev += "${libdir}/cmake/collada_dom-2.4/*.cmake"
