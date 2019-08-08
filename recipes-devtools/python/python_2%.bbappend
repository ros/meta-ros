# Backport
# commit 98ba7ba8c5bc091f5cc590299f1a636c9b8dc1f5
# Author: Alexander Kanavin <alex.kanavin@gmail.com>
# Date:   Wed Feb 6 17:26:36 2019 +0100
# Subject: python: make the python 3.x version of 2to3 utility the default one
# because our backported python3 now installs it's own 2to3 and
# python-2to3 and python3-2to3 conflict with each other when both are installed in the same image.

do_install_append() {
    # Python 3.x version of 2to3 is now the default
    mv ${D}/${bindir}/2to3 ${D}/${bindir}/2to3-${PYTHON_MAJMIN}
}

# Cannot use FILES_python-2to3_append, because anonymous python function
# in python_2*.bb is executed later and starts by reseting FILES_python-2to3
python() {
    d.appendVar('FILES_python-2to3', ' ${bindir}/2to3-${PYTHON_MAJMIN}')
}
