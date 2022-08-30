ROS_EXEC_DEPENDS:append = " \
    python3 \
"

# This is necessary as setuptools replaces shebang on install_script with
# current executable, which then is from sysroot native... 
do_install:append() {
    cd ${D}${libdir}/${ROS_BPN}
    sed -i "1s/.*/\#\!\/usr\/bin\/env python3/" *spawner
}
