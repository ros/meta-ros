# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    generate-parameter-library-py-native \
"

# QA Issue: File /opt/ros/humble/share/gripper_controllers/cmake/export_gripper_action_controllerExport.cmake in package gripper-controllers-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}[^;]*;##g" ${D}${ros_datadir}/${ROS_BPN}/cmake/export_gripper_action_controllerExport.cmake
    sed -i -e 's#${RECIPE_SYSROOT}[^"]*##g' ${D}${ros_datadir}/${ROS_BPN}/cmake/export_gripper_action_controllerExport.cmake
}
