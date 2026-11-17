SUMMARY = "Relocatable CMake package configuration for libyaml"
DESCRIPTION = "oe-core's libyaml is built with autotools and installs only a \
pkg-config file. Some ROS packages use find_package(yaml) and would otherwise \
embed absolute sysroot paths found via pkg-config in their exported CMake \
files. This recipe installs a yamlConfig.cmake that defines an imported 'yaml' \
target with paths computed from CMAKE_CURRENT_LIST_DIR. The version must match \
the libyaml recipe in oe-core."
HOMEPAGE = "https://pyyaml.org/wiki/LibYAML"
SECTION = "libs/devel"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://yamlConfig.cmake \
           file://yamlConfigVersion.cmake \
"

S = "${UNPACKDIR}"

DEPENDS = "libyaml"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}${libdir}/cmake/yaml
    install -m 0644 ${UNPACKDIR}/yamlConfig.cmake ${D}${libdir}/cmake/yaml/
    sed -e 's|@PV@|${PV}|' ${UNPACKDIR}/yamlConfigVersion.cmake > ${D}${libdir}/cmake/yaml/yamlConfigVersion.cmake
}

# Only a -dev package is useful: the files belong in the sysroot.
FILES:${PN} = ""
FILES:${PN}-dev = "${libdir}/cmake/yaml"
ALLOW_EMPTY:${PN} = "1"
RDEPENDS:${PN}-dev += "libyaml-dev"

BBCLASSEXTEND = "native nativesdk"
