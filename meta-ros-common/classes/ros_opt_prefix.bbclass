#
# Copyright (c) 2013 Stefan Herbrechtsmeier, Bielefeld University
# Copyright (c) 2019 LG Electronics, Inc.
#

ros_prefix ?= "${base_prefix}/opt/ros/${ROS_DISTRO}"

ros_bindir = "${ros_prefix}/bin"
ros_libdir = "${ros_prefix}/${baselib}"
ros_libexecdir = "${ros_libdir}/${ROS_BPN}"
ros_includedir = "${ros_prefix}/include"
ros_datadir = "${ros_prefix}/share"
ros_sysconfdir = "${ros_prefix}/etc"
ros_stacksdir = "${ros_prefix}/stacks"

# Used by chrpath.bbclass
PREPROCESS_RELOCATE_DIRS += " \
    ${ros_bindir} \
    ${ros_libdir} \
"

# ROS_PYTHON_VERSION is set in generated/superflore-ros-distro.inc, ie, it will never be unset here.
inherit ${@'python3-dir' if d.getVar('ROS_PYTHON_VERSION') == '3' else 'python-dir'}

PKG_CONFIG_PATH .= ":${PKG_CONFIG_DIR}:${STAGING_DIR_HOST}${ros_libdir}/pkgconfig:${STAGING_DATADIR}/pkgconfig"
PYTHON_SITEPACKAGES_DIR = "${ros_libdir}/${PYTHON_DIR}/site-packages"
export PYTHONPATH = "${STAGING_DIR_NATIVE}${PYTHON_SITEPACKAGES_DIR}"
PYTHONPATH_class-native = "${PYTHON_SITEPACKAGES_DIR}"

FILES_${PN} += "\
    ${ros_bindir} ${ros_libexecdir} ${ros_libdir}/lib*.so \
    ${PYTHON_SITEPACKAGES_DIR} \
    ${ros_datadir} \
    ${ros_sysconfdir} \
    ${ros_stacksdir} \
    "

FILES_${PN}-dev += "\
    ${ros_includedir} \
    ${ros_libdir}/pkgconfig \
    ${PYTHON_SITEPACKAGES_DIR}/*.la \
    ${ros_datadir}/${ROS_BPN}/cmake \
    ${datadir}/${ROS_BPN}/cmake \
    ${datadir}/${ROS_BPN}/*.template \
    "

FILES_${PN}-dbg += "\
    ${ros_bindir}/.debug ${ros_libexecdir}/.debug ${ros_libdir}/.debug \
    ${ros_datadir}/*/bin/.debug \
    ${PYTHON_SITEPACKAGES_DIR}/.debug \
    ${PYTHON_SITEPACKAGES_DIR}/*/.debug \
    ${PYTHON_SITEPACKAGES_DIR}/*/*/.debug \
    "

FILES_${PN}-staticdev += "\
    ${ros_libdir}/*.a \
    ${ros_libdir}/${BPN}/*.a \
    "

SYSROOT_DIRS_append = " \
    ${ros_includedir} \
    ${ros_libdir} \
    ${ros_datadir} \
    ${ros_stacksdir} \
    ${ros_sysconfdir} \
    "

SYSROOT_DIRS_NATIVE_append = " \
    ${ros_bindir} \
    ${ros_libexecdir} \
    "

# The libraries are installed in ros_libdir and if ros_libdir starts with /usr/ it will be catched by libdir QA checker showing errors like these:
# ERROR: filters-1.8.1-r0 do_package_qa: QA Issue: filters-dbg: found library in wrong location: /usr/opt/ros/melodic/lib/.debug/libmean.so
# filters-dbg: found library in wrong location: /usr/opt/ros/melodic/lib/.debug/libtransfer_function.so
# filters-dbg: found library in wrong location: /usr/opt/ros/melodic/lib/.debug/libparams.so
# filters-dbg: found library in wrong location: /usr/opt/ros/melodic/lib/.debug/libmedian.so
# filters-dbg: found library in wrong location: /usr/opt/ros/melodic/lib/.debug/libincrement.so
# filters: found library in wrong location: /usr/opt/ros/melodic/lib/libmean.so
# filters: found library in wrong location: /usr/opt/ros/melodic/lib/libtransfer_function.so
# filters: found library in wrong location: /usr/opt/ros/melodic/lib/libparams.so
# filters: found library in wrong location: /usr/opt/ros/melodic/lib/libmedian.so
# filters: found library in wrong location: /usr/opt/ros/melodic/lib/libincrement.so [libdir]
INSANE_SKIP_${PN}-dbg += "libdir"
INSANE_SKIP_${PN} += "libdir"
