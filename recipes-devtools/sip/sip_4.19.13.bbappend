# Copyright (c) 2019 LG Electronics, Inc.

# Can't figure out how to fix sip.cfg to generate these files correctly, so just post-process them to have the correct paths.
# NB. sip.inc creates paths with doubled slashes.
do_configure_class-target() {
    sed -i -e 's@$(DESTDIR)${RECIPE_SYSROOT}@$(DESTDIR)${D}@g' Makefile
    sed -i -e 's@//@/@g' -e 's@${RECIPE_SYSROOT}@${D}@g' installed.txt
    sed -i -e 's@//@/@g' -e 's@${D}@${RECIPE_SYSROOT}@g' sipconfig.py
}

do_configure_class-native() {
    sed -i -e 's@$(DESTDIR)${RECIPE_SYSROOT_NATIVE}@$(DESTDIR)${D}${RECIPE_SYSROOT_NATIVE}@g' Makefile
    sed -i -e 's@//@/@g' -e 's@^${RECIPE_SYSROOT_NATIVE}@${D}${RECIPE_SYSROOT_NATIVE}@g' installed.txt
    sed -i -e 's@//@/@g' -e 's@${D}@@g' sipconfig.py
}

SSTATE_SCAN_FILES_append = " *.py"

# There's no way to add STRIP="" to configure.py command line in do_configure_class-native(), so just ignore the warning:
#   WARNING: sip-native-4.19.13-r0 do_populate_sysroot:
#     File '.../work/x86_64-linux/sip-native/4.19.13-r0/recipe-sysroot-native/usr/lib/python2.7/site-packages/PyQt5/sip.so'
#     from sip-native was already stripped, this will prevent future debugging!
INSANE_SKIP_${PN}_class-native += "already-stripped"
