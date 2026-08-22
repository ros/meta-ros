# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

# The value from package.xml breaks parsing it with bitbake. The .replace()-based
# workaround this used to carry only matched an older, apostrophe-containing
# generated LICENSE string (see the old QA warning below) and had become a
# silent no-op against the current generated value, which uses AND as a
# literal word instead of & -- fatal on wrynose. Direct assignment instead.
# Old QA warning this originally worked around:
# WARNING: /meta-ros/meta-ros2-rolling/generated-recipes/ur-description/ur-description_2.2.1-1.bb: QA Issue: ur-description: LICENSE value "BSD-3-Clause & Universal-Robots-A-S’-Terms-and-Conditions-for-Use-of-Graphical-Documentation" has an invalid separator "Universal-Robots-A-S’-Terms-and-Conditions-for-Use-of-Graphical-Documentation" that is not in the valid list of separators (&|() ) [license-format]
_LICENSE := "${LICENSE}"
LICENSE = "${@'${_LICENSE}'.replace('LicenseRef-Universal-Robots-A-S--Terms-and-Conditions-for-Use-of-Graphical-Documentation', 'LicenseRef-Universal-Robots-A-S')}"

# ERROR: ur-description: No generic license file exists for: LicenseRef-Universal-Robots-A-S in any provider [license-exists]
NO_GENERIC_LICENSE[Universal-Robots-A-S] = "meshes/ur20/LICENSE.txt"
LIC_FILES_CHKSUM += "file://meshes/ur20/LICENSE.txt;md5=eeb3173b670d1ffe6a30ce4d2ad45ee3"

