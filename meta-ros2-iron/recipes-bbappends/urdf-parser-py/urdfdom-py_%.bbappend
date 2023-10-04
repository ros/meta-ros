# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "\
    file://0001-setup.cfg-fix-warning.patch \
    file://0002-setup.py-install-data_files-without-share-prefix.patch \
"

# similar to what distutil3.bbclass does here:
# https://git.openembedded.org/openembedded-core/tree/meta/classes/distutils3.bbclass?h=hardknott#n46
# but the files we want to modify aren't in ${bindir}/${sbindir}, but ${datadir}/urdfdom_py/scripts/

# $ head -n 1 tmp-glibc/work/qemux86-webos-linux/urdfdom-py/1.1.0-1-r0/packages-split/urdfdom-py/usr/share/urdfdom_py/scripts/display_urdf
#!/jenkins/mjansa/build/ros/webos-rolling-hardknott/tmp-glibc/work/qemux86-webos-linux/urdfdom-py/1.1.0-1-r0/recipe-sysroot-native/usr/bin/python3-native/python3
do_install:append() {
    for i in ${D}${datadir}/urdfdom_py/scripts/*; do
        if [ -f "$i" ]; then
            sed -i -e s:${PYTHON}:${USRBINPATH}/env\ ${DISTUTILS_PYTHON}:g $i
            sed -i -e s:${STAGING_BINDIR_NATIVE}:${bindir}:g $i
        fi
    done
}
