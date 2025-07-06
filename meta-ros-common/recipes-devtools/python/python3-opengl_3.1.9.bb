LICENSE = "BSD-3-Clause & MIT & Unknown"
LIC_FILES_CHKSUM = "file://license.txt;md5=943332dbb441a49d1576fe75197d6cac"

SRC_URI = "git://github.com/mcfletch/pyopengl;protocol=https;branch=master"

PV = "3.1.9"
SRCREV = "5dfca4745d3b124bb0020fb8b1f84b4579ae1739"

inherit setuptools3

RDEPENDS:${PN} += "\
    python3-core \
    python3-ctypes \
    python3-datetime \
    python3-debugger \
    python3-logging \
    python3-numpy \
    python3-pickle \
    python3-shell \
    python3-six \
    python3-tkinter \
"
