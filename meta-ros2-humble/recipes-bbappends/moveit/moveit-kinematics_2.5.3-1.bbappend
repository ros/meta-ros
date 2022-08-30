ROS_BUILD_DEPENDS:append = " \
    moveit-ros-planning \
"

#fixing qa [file-rdeps]
ROS_EXEC_DEPENDS:append = " \
   bash \
"

# fixing qa [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/*.so \
"

#fixing qa [dev-deps] [dev-elf]
do_install:append() {
    mv ${D}${libdir}/libmoveit_kdl_kinematics_plugin.so  ${D}${libdir}/libmoveit_kdl_kinematics_plugin.so.2.5.3
    ln -s ${D}${libdir}/libmoveit_kdl_kinematics_plugin.so.2.5.3 libmoveit_kdl_kinematics_plugin.so
}