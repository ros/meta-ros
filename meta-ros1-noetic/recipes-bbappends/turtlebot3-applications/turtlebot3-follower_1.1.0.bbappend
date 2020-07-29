# Copyright (c) 2019 LG Electronics, Inc.

do_configure_prepend() {
    sed -i -e '/install(DIRECTORY / s@$@ launch@' \
           -e '/install(PROGRAMS$/ s@$@ config/add_comment config/add_data config/clf config/clf2@' \
           ${S}/CMakeLists.txt
}
