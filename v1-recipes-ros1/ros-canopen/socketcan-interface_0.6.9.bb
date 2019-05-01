DESCRIPTION = "This package contains a generic CAN interface description with helpers for filtering and driver implementation. Further a socketcan implementation based on boost::asio is included."
SECTION = "devel"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=b691248d2f70cdaeeaf13696ada5d47c"

DEPENDS = "boost class-loader virtual/kernel"

require ros-canopen.inc

SRC_URI += "file://0001-find-and-link-the-thread-library-properly.patch;striplevel=2"
SRC_URI += "file://0001-compile-also-with-boost-1.66.0.patch;striplevel=2"

# libclass_loader.so: error: undefined reference to 'pthread_mutexattr_destroy', 'pthread_mutexattr_settype', 'pthread_mutexattr_init'
LDFLAGS_append = "${@bb.utils.contains('DISTRO_FEATURES', 'ld-is-gold', ' -fuse-ld=bfd ', '', d)}"
