# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

# The value from package.xml breaks parsing it with bitbake.
# Superflore replaces it with ""BSD-3-Clause & Universal-Robots-A-S’-Terms-and-Conditions-for-Use-of-Graphical-Documentation", but that still doesn't parse well:
# WARNING: /meta-ros/meta-ros2-rolling/generated-recipes/ur-description/ur-description_2.2.1-1.bb: QA Issue: ur-description: LICENSE value "BSD-3-Clause & Universal-Robots-A-S’-Terms-and-Conditions-for-Use-of-Graphical-Documentation" has an invalid separator "Universal-Robots-A-S’-Terms-and-Conditions-for-Use-of-Graphical-Documentation" that is not in the valid list of separators (&|() ) [license-format]
_LICENSE := "${LICENSE}"
LICENSE = "${@'${_LICENSE}'.replace('BSD-3-Clause & Universal-Robots-A-S’-Terms-and-Conditions-for-Use-of-Graphical-Documentation', 'BSD-3-Clause & Universal-Robots-A-S')}"

