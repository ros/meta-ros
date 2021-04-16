# Copyright (c) 2021 LG Electronics, Inc.

# ERROR: iceoryx-posh-0.99.7-1-r0 do_package: QA Issue: iceoryx-posh: Files/directories were installed but not shipped in any package:
#  /usr/etc
#  /usr/etc/roudi_config_example.toml
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# iceoryx-posh: 2 installed and not shipped files. [installed-vs-shipped]
do_install_append () {
    if [ -d ${D}${prefix}${sysconfdir} ] ; then
        mv ${D}${prefix}${sysconfdir} ${D}${sysconfdir}
    fi
}
