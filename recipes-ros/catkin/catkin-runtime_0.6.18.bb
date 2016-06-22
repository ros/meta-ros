ROS_SPN = "catkin"

require catkin.inc

S = "${WORKDIR}/catkin-${PV}"

DEPENDS = "python-catkin-pkg catkin-native"

# Disable binary package option to generate setup scripts and .catkin marker
### TODO: ENABLE GENERATION OF SETUP UTILS
# EXTRA_OECMAKE += "-DCATKIN_BUILD_BINARY_PACKAGE=OFF"

# The "catkin-runtime" package includes ONLY the python packages AND catkin_find
# The "catkin" package includes all other files from the catkin tool.
FILES_${PN} = "\
    ${ros_bindir}/catkin_find \
    ${PYTHON_SITEPACKAGES_DIR} \
    ${ros_prefix}/.catkin \
    "

### TODO: ENABLE GENERATION OF SETUP UTILS
#     ${ros_prefix}/.rosinstall \
#     ${ros_prefix}/_setup_util.py \
#     ${ros_prefix}/env.sh \
#     ${ros_prefix}/setup.* \
#     "

FILES_${PN}-dev = ""

RDEPENDS_${PN} += "\
    python-argparse \
    python-codecs \
    python-datetime \
    python-docutils \
    python-io \
    python-misc \
    python-multiprocessing \
    python-re \
    python-shell \
    python-subprocess \
    python-catkin-pkg \
    "

RDEPENDS_${PN}_class-native += "\
    python-native \
    python-catkin-pkg-native \
    "

# Delete everything but the python packages in order to avoid
# that the QA error [installed-vs-shipped] hits on us.
do_install_append() {
    rm  ${D}${ros_bindir}/catkin_*_*
    rm  ${D}${ros_bindir}/catkin_make
    rm -rf ${D}${ros_datadir}
    rm -rf ${D}${ros_libdir}/pkgconfig
    rm -rf ${D}${ros_sysconfdir}
    rm -rf ${D}${ros_stacksdir}

### TODO: ENABLE GENERATION OF SETUP UTILS
    touch ${D}${ros_prefix}/.catkin
}

# Append environment hook for SDK
do_install_append_class-nativesdk() {
    mkdir -p ${D}${SDKPATHNATIVE}/environment-setup.d
    script=${D}${SDKPATHNATIVE}/environment-setup.d/catkin-runtime.sh
    echo "export PATH=\$PATH:\${OECORE_NATIVE_SYSROOT}/opt/ros/${ROSDISTRO}/bin" >> $script
    echo "export PYTHONPATH=\${OECORE_NATIVE_SYSROOT}/opt/ros/${ROSDISTRO}/lib/python2.7/site-packages" >> $script
    echo "export ROS_ROOT=\${OECORE_TARGET_SYSROOT}/opt/ros/${ROSDISTRO}/share/ros" >> $script
    echo "export CMAKE_PREFIX_PATH=\${OECORE_TARGET_SYSROOT}/opt/ros/${ROSDISTRO}:\${OECORE_NATIVE_SYSROOT}/opt/ros/${ROSDISTRO}" >> $script
}

FILES_${PN}_append_class-nativesdk = " ${SDKPATHNATIVE}"

### TODO: ENABLE GENERATION OF SETUP UTILS
# # Fix shebang of setup script & default location
# do_install_append() {
#     sed -i "s|${PYTHON}|/usr/bin/env python|g" ${D}${ros_prefix}/_setup_util.py
#     sed -i "s|_CATKIN_SETUP_DIR:=${ros_prefix}|_CATKIN_SETUP_DIR:=${STAGING_DIR_NATIVE}${ros_prefix}|g" ${D}${ros_prefix}/setup.sh
# }
#
# # Fix paths
# catkin_package_preprocess_append() {
#     _catkin_clean_paths ${PKGD}${ros_prefix}/_setup_util.py
#     _catkin_clean_paths ${PKGD}${ros_prefix}/setup.sh
# }

# Include marker file in sysroot
catkin_sysroot_preprocess_append() {
    cp ${D}${ros_prefix}/.catkin ${SYSROOT_DESTDIR}${ros_prefix}
}

BBCLASSEXTEND += "native nativesdk"
