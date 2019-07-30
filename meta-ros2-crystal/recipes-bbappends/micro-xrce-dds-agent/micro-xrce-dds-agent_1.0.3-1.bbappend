# Copyright (c) 2019 LG Electronics, Inc.

# This is sooo much easier than figuring out why CMake isn't using TINYXML2_LIBRARY when generating build.ninja
do_configure_append() {
    if [ -e ${B}/build.ninja ]; then
        sed -i -e 's@ /libtinyxml2.so@ ${STAGING_LIBDIR}/libtinyxml2.so@g' \
               -e 's@ -ltinyxml2@ ${STAGING_LIBDIR}/libtinyxml2.so@g' \
	       ${B}/build.ninja
    else
        true
    fi
}
