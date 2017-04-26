# Usually ROS packages include libraries without so-names. But some packages insist
# on setting so-names to indicate ABI breakages between different versions of the
# same library in the same ROS distro. E.g. see
# https://github.com/ros-planning/moveit/commit/0a7a895bb2ae9e171efa101f354826366fa5eaff
INSANE_SKIP_${PN} += "dev-so"

FILES_${PN} += "\
        ${ros_libdir}/lib*.so.* \
"
