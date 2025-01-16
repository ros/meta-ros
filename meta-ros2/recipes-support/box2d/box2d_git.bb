SUMMARY = "2D physics engine"
DESCRIPTION = "Box2D is a 2D physics engine for games"
HOMEPAGE = "https://box2d.org/"
DEPENDS += "virtual/libx11 xrandr libxinerama libxcursor xinput"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f98ad1ab668cef3f7a990d800fea3e27"

SRC_URI = "git://github.com/erincatto/box2d.git;branch=main;protocol=https"
SRCREV = "9dc24a6fd4f32442c4bcf80791de47a0a7d25afb"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "-DBUILD_SHARED_LIBS=ON"
