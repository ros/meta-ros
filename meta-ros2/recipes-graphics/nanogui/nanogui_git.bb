DESCRIPTION = "Minimalistic C++/Python GUI library for OpenGL, GLES2/3, Metal, and WebAssembly/WebGL"
HOMEPAGE = "https://github.com/mitsuba-renderer/nanogui"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=cea9322f8f8f3489fa38b53cf3c03983"

DEPENDS = "glfw python3"

S = "${WORKDIR}/git" 

SRC_URI = " \
    git://github.com/mitsuba-renderer/nanogui.git;name=nanogui;protocol=https;branch=master \
    git://github.com/wjakob/nanovg.git;name=nanovg;protocol=https;branch=master;destsuffix=git/ext/nanovg \
    git://github.com/wjakob/nanovg_metal.git;name=nanovg-metal;protocol=https;branch=master;destsuffix=git/ext/nanovg_metal \
    git://github.com/wjakob/nanobind.git;name=nanobind;protocol=https;branch=master;destsuffix=git/ext/nanobind \
    git://github.com/wjakob/glfw.git;name=glfw;protocol=https;branch=master;destsuffix=git/ext/glfw \
    git://github.com/Tessil/robin-map.git;name=robin-map;protocol=https;branch=master;destsuffix=git/ext/nanobind/ext/robin_map \
    file://0001-set-nanobind-dir.patch \
"
SRCREV_nanogui = "2ee903c96480d4aee54542ea3c340c13cc06dc32"
SRCREV_nanovg = "7acc5d509f70e038d9229753d4b0f20e77e7f279"
SRCREV_nanovg-metal = "075b04f16c579728c693b46a2ce408f2325968cf"
SRCREV_nanobind = "ea2569f705b9d12185eea67db399a373d37c75aa"
SRCREV_glfw = "e130e55a990998c78fd323f21076e798e0efe8a4"
SRCREV_robin-map = "5eace6f74c9edff8e264c2d26a85365ad9ea149c"
SRCREV_FORMAT = "nanogui-nanvg-nanovg-metal-nanobind-glfw_robin-map"

FILES:${PN} += " \
    ${libdir}/nanogui_ext.cpython-310-x86_64-linux-gnu.so \
    ${libdir}/libnanogui.so \
    ${datadir}/fonts/truetype/fonts-entypo/entypo.ttf \
"
FILES:${PN}-dev = "${includedir} ${datadir}/cmake"

do_install:append () {
    rm ${D}${includedir}/GLFW/*

    install -d ${D}${datadir}/fonts/truetype/fonts-entypo
    install -m 0600 ${S}/docs/_static/entypo.ttf ${D}${datadir}/fonts/truetype/fonts-entypo
#./git/resources/Roboto-Regular.ttf
#./git/resources/FontAwesome-Solid.ttf
#./git/resources/Roboto-Bold.ttf
#./git/resources/Inconsolata-Regular.ttf
}

INSANE_SKIP:${PN} += "already-stripped"
inherit cmake python3native
