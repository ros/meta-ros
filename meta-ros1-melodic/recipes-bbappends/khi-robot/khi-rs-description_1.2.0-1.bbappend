# Copyright (c) 2021 LG Electronics, Inc.

# The value from package.xml "BSD & KHI CAD license (mesh data, see readme)" breaks parsing it with bitbake.
# Superflore replaces it with "BSD & KHI-CAD-license-mesh-data,-see-readme-", but that still doesn't parse well:
# WARNING: /jenkins/mjansa/build/ros/webos-melodic-hardknott/meta-ros/meta-ros1-melodic/generated-recipes/khi-robot/khi-duaro-description_1.2.0-1.bb: khi-duaro-description: LICENSE value "BSD & KHI-CAD-license-mesh-data,-see-readme-" has an invalid separator "KHI-CAD-license-mesh-data,-see-readme-" that is not in the valid list of separators (&|() )
_LICENSE := "${LICENSE}"
LICENSE = "${@'${_LICENSE}'.replace('BSD & KHI-CAD-license-mesh-data,-see-readme-', 'BSD & KHI-CAD-license')}"
