require rostest.inc

DEPENDS = "boost-native rosunit-native"

inherit native

OECMAKE_EXTRA_ROOT_PATH = "${OECMAKE_BUILDPATH}/devel"
