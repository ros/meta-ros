DEPENDS += "lely-core-libraries-native"

# dcfgen and cogen are located in /opt/ros/<DISTRO>/bin
do_compile:prepend:class-target() {
    export PATH=${STAGING_DIR_NATIVE}${ros_bindir}:$PATH
}
