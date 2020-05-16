# Copyright (c) 2020 LG Electronics, Inc.

# python-tkinter is just a package created by python, python-tk is mapped to python-tkinter
# to get the correct runtime dependencies, but exotica-python is using the same variable
# also for build time dependency
DEPENDS_remove = "python-tkinter"

# For some reason ends with bad RPATH
# WARNING: exotica-python-5.1.3-3-r0 do_package_qa: QA Issue:
# package exotica-python contains bad RPATH /jenkins/mjansa/build/ros/ros1-melodic-thud/tmp-glibc/work/aarch64-oe-linux/exotica-python/5.1.3-3-r0/recipe-sysroot/opt/ros/melodic/lib: in file /jenkins/mjansa/build/ros/ros1-melodic-thud/tmp-glibc/work/aarch64-oe-linux/exotica-python/5.1.3-3-r0/packages-split/exotica-python/opt/ros/melodic/lib/python2.7/site-packages/python2.7/site-packages/pyexotica/_pyexotica.so [rpaths]
do_install_append() {
    # and there is also 2nd copy of _pyexotica in wrong directory (python2.7/site-packages twice in the path)
    # they are big 44M and not completely identical, remove the 2nd copy
    # ros1-melodic-thud/tmp-glibc/work/aarch64-oe-linux/exotica-python/5.1.3-3-r0$ ls -lah image/opt/ros/melodic/lib/python2.7/site-packages/pyexotica/_pyexotica.so image/opt/ros/melodic/lib/python2.7/site-packages/python2.7/site-packages/pyexotica/_pyexotica.so
    # -rwxr-xr-x 1 mjansa mjansa 44M May 16 16:40 image/opt/ros/melodic/lib/python2.7/site-packages/pyexotica/_pyexotica.so
    # -rwxr-xr-x 1 mjansa mjansa 44M May 16 16:40 image/opt/ros/melodic/lib/python2.7/site-packages/python2.7/site-packages/pyexotica/_pyexotica.so
    # ros1-melodic-thud/tmp-glibc/work/aarch64-oe-linux/exotica-python/5.1.3-3-r0$ md5sum image/opt/ros/melodic/lib/python2.7/site-packages/pyexotica/_pyexotica.so image/opt/ros/melodic/lib/python2.7/site-packages/python2.7/site-packages/pyexotica/_pyexotica.so
    # 9ea15f6ac7c73a6d119b0cf26d445b51  image/opt/ros/melodic/lib/python2.7/site-packages/pyexotica/_pyexotica.so
    # 40aaa5ea6398184c595ce8195a312b7f  image/opt/ros/melodic/lib/python2.7/site-packages/python2.7/site-packages/pyexotica/_pyexotica.so
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/python2.7
}
