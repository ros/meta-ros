# Copyright (c) 2019-2020 LG Electronics, Inc.

# This component puts *_proc files under libdir.
FILES_${PN}_prepend = " \
    ${datadir}/lib/${ROS_BPN} \
"

PNBLACKLIST[launch-testing-native] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'launch', 'launch: depends on launch-native', '', d)}"
