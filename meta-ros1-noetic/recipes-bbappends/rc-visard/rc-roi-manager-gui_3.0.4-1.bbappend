# Copyright (c) 2020 LG Electronics, Inc.

do_configure_prepend() {
    # wx-config is installed in uncommon location, we need to export
    # WX_CONFIG for https://cmake.org/cmake/help/v3.0/module/FindwxWidgets.html
    # to find it
    export WX_CONFIG="${RECIPE_SYSROOT}${libdir}/wx/config/wx-config"
}
