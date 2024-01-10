LICENSE = "Apache-2.0 & MIT & Unknown"
LIC_FILES_CHKSUM = "file://subpackages/matplotlib_cpp/LICENSE;md5=86ba017c9754ed4e29135f9bb71c5e1b \
                    file://subpackages/matplotlib_cpp/LICENSE.matplotlib;md5=50a89c4f7c0aa1cff255a99880f40273"

SRC_URI = " \
  git://github.com/miferco97/dynamic_trajectory_generator.git;protocol=https;branch=master \
  file://find_nlopt.patch \
"

PV = "1.0+git${SRCPV}"
SRCREV = "3bddf06c4a9fc1b32f5abe4406aa70d2c636e026"

S = "${WORKDIR}/git"

inherit cmake

DEPENDS = " \
  glog \
  libeigen \
  nlopt \
  yaml-cpp \
"

do_install() {
    install -d -m 0755 ${D}/${libdir}
    install -D -m 0644 ${B}/libdynamic_trajectory_generator.a ${D}/${libdir}
    install -D -m 0644 ${B}/subpackages/mav_trajectory_generation/libmav_trajectory_generation.a ${D}/${libdir}

    install -d -m 0755 ${D}/${includedir}/dynamic_trajectory_generator
    install -D -m 0644 ${S}/include/dynamic_trajectory_generator/*.hpp ${D}/${includedir}/dynamic_trajectory_generator

    install -d -m 0755 ${D}/${includedir}/dynamic_trajectory_generator/utils
    install -D -m 0644 ${S}/include/dynamic_trajectory_generator/utils/*.hpp ${D}/${includedir}/dynamic_trajectory_generator/utils

    install -d -m 0755 ${D}/${includedir}/mav_trajectory_generation
    install -d -m 0755 ${D}/${includedir}/mav_msgs
    install -D -m 0644 ${S}/subpackages/mav_trajectory_generation/include/mav_msgs/*.hpp ${D}/${includedir}/mav_msgs

    install -d -m 0755 ${D}/${includedir}/mav_trajectory_generation
    install -D -m 0644 ${S}/subpackages/mav_trajectory_generation/include/mav_trajectory_generation/*.h ${D}/${includedir}/mav_trajectory_generation

    install -d -m 0755 ${D}/${includedir}/mav_trajectory_generation/impl
    install -D -m 0644 ${S}/subpackages/mav_trajectory_generation/include/mav_trajectory_generation/impl/*.h ${D}/${includedir}/mav_trajectory_generation/impl

    install -d -m 0755 ${D}/${includedir}/mav_trajectory_generation/rpoly
    install -D -m 0644 ${S}/subpackages/mav_trajectory_generation/include/mav_trajectory_generation/rpoly/*.h ${D}/${includedir}/mav_trajectory_generation/rpoly
}

inherit python3native

FILES:${PN}-dev += " ${libdir}/libdynamic_trajectory_generator.a ${libdir}/libmav_trajectory_generation.a"
