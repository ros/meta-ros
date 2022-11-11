# fixing qa [installed-vs-shipped]
do_install:append() {
    install -m 755 -d ${D}/usr/lib
    mv ${D}/usr/share/lib/rqt_gui ${D}/usr/lib/
    rm -Rf ${D}/usr/share/lib
}    