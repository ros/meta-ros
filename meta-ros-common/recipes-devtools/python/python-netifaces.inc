DESCRIPTION = "Portable network interface information for Python"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=a53cbc7cb75660694e138ba973c148df"
PYPI_PACKAGE = "netifaces"

SRC_URI[md5sum] = "5b4d1f1310ed279e6df27ef3a9b71519"
SRC_URI[sha256sum] = "59d8ad52dd3116fcb6635e175751b250dc783fb011adba539558bd764e5d628b"

inherit pypi

BBCLASSEXTEND += "native"
