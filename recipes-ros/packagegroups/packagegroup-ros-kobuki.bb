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
    yocs-ar-marker-tracking \
    yocs-ar-pair-approach \
    yocs-ar-pair-tracking \
    yocs-cmd-vel-mux \
    yocs-controllers \
    yocs-diff-drive-pose-controller \
    yocs-joyop \
    yocs-keyop \
    yocs-localization-manager \
    yocs-math-toolkit \
    yocs-msgs \
    yocs-navigator \
    yocs-rapps \
    yocs-safety-controller \
    yocs-velocity-smoother \
    yocs-virtual-sensor \
    yocs-waypoint-provider \
    yocs-waypoints-navi \
    capabilities \
    std-capabilities \
    unique-id \
    uuid-msgs \
"
