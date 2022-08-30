# This is needed so iceoryx-posh will find the cmake files provided by
# iceoryx-hoofs.
EXTRA_OECMAKE:append = " -DCMAKE_MODULE_PATH=${STAGING_DIR_TARGET}/usr/lib/cmake/iceoryx_hoofs/\;${STAGING_DIR_TARGET}/usr/lib/cmake/iceoryx_posh/\; "
