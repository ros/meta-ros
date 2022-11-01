
# The includes do not get picked up correctly else
do_install:append() {
    install -m 755 -d ${D}${includedir}/${PYTHON_DIR}
    mv ${D}${libdir}/${PYTHON_DIR}/site-packages/numpy/core/include/numpy ${D}${includedir}/${PYTHON_DIR}
}  