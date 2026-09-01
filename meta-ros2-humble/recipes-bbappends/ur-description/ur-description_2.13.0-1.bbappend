# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

# The value from package.xml breaks parsing it with bitbake.
# Superflore replaces it with ""BSD-3-Clause & Universal-Robots-A-S’-Terms-and-Conditions-for-Use-of-Graphical-Documentation", but that still doesn't parse well:
# ERROR: ur-description-2.1.1-1-r0: invalid characters in license 'Universal-Robots-A-S’-Terms-and-Conditions-for-Use-of-Graphical-Documentation'
_LICENSE := "${LICENSE}"
LICENSE = "${@'${_LICENSE}'.replace('BSD-3-Clause & Universal-Robots-A-S’-Terms-and-Conditions-for-Use-of-Graphical-Documentation', 'BSD-3-Clause & Universal-Robots-A-S')}"
