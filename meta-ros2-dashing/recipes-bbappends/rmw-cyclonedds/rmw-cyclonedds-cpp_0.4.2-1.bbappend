# Copyright (c) 2019 LG Electronics, Inc.

do_configure_prepend() {
    # Don't try to use /usr/local/lib from host when cross-compiling
    sed -i 's@^link_directories(/usr/local/lib)@#link_directories(/usr/local/lib)@g' ${S}/CMakeLists.txt
}
