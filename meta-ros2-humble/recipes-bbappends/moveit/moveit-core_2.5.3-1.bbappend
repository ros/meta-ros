ROS_BUILD_DEPENDS:append = " \
    tf2-kdl \
"

## fixing package qa issues: [dev-elf], [dev-deps] and [dev-so]
do_install:append() {
    mv ${D}${libdir}/libmoveit_kinematics_base.so ${D}${libdir}/libmoveit_kinematics_base.so.${PV}
    ln -s libmoveit_kinematics_base.so.${PV} ${D}${libdir}/libmoveit_kinematics_base.so
}

FILES:${PN}-dev += " \
    ${libdir}/lib*.so \
"