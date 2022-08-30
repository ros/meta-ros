# fixing qa [installed-vs-shipped]
do_install:append () {
    rm -f ${D}/usr/share/lib/launch_param_builder/example_node.py
    rm -Rf ${D}/usr/share/lib
}