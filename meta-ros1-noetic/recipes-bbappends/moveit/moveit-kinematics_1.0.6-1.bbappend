# Copyright (c) 2020 LG Electronics, Inc.

# ERROR: QA Issue: moveit-kinematics: Files/directories were installed but not shipped in any package:
#   /usr/opt/ros/melodic/lib/libmoveit_cached_ik_kinematics_plugin.so.1.0.2
#   /usr/opt/ros/melodic/lib/libmoveit_kdl_kinematics_plugin.so.1.0.2
#   /usr/opt/ros/melodic/lib/libmoveit_srv_kinematics_plugin.so.1.0.2
#   /usr/opt/ros/melodic/lib/libmoveit_lma_kinematics_plugin.so.1.0.2
#   /usr/opt/ros/melodic/lib/libmoveit_cached_ik_kinematics_base.so.1.0.2
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# moveit-kinematics: 5 installed and not shipped files. [installed-vs-shipped]
inherit ros_insane_dev_so

# ERROR: moveit-kinematics-1.0.2-1-r0 do_package_qa: QA Issue: /usr/opt/ros/melodic/lib/moveit_kinematics/auto_create_ikfast_moveit_plugin.sh contained in package moveit-kinematics requires /bin/bash, but no providers found in RDEPENDS_moveit-kinematics? [file-rdeps]
RDEPENDS_${PN} += "bash"

# This is needed only for webOS OSE and it's not in meta-ros-webos, because
# then meta-ros-webos would need to include this .bbappend just when
# meta-ros1-melodic layer is included
VIRTUAL-RUNTIME_bash ?= "bash"
RDEPENDS_${PN}_append_class-target_webos = " ${VIRTUAL-RUNTIME_bash}"
RDEPENDS_${PN}_remove_class-target_webos = "${@oe.utils.conditional('WEBOS_PREFERRED_PROVIDER_FOR_BASH', 'busybox', 'bash', '', d)}"
