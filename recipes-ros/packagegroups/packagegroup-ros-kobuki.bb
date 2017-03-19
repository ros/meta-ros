DESCRIPTION = "ros-kobuki package group"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS_${PN} = "\
    ecl-build \
    ecl-command-line \
    ecl-concepts \
    ecl-config \
    ecl-console \
    ecl-containers \
    ecl-converters \
    ecl-converters-lite \
    ecl-core-apps \
    ecl-devices \
    ecl-eigen \
    ecl-errors \
    ecl-exceptions \
    ecl-filesystem \
    ecl-formatters \
    ecl-geometry \
    ecl-io \
    ecl-ipc \
    ecl-license \
    ecl-linear-algebra \
    ecl-math \
    ecl-mobile-robot \
    ecl-mpl \
    ecl-sigslots \
    ecl-sigslots-lite \
    ecl-statistics \
    ecl-streams \
    ecl-threads \
    ecl-time \
    ecl-time-lite \
    ecl-type-traits \
    ecl-utilities \
"
