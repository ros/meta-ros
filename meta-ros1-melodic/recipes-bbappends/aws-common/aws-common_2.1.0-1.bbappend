# Copyright (c) 2020 LG Electronics, Inc.

DEPENDS += "aws-cpp-sdk curl openssl"

EXTRA_OECMAKE = "-DEXTERNAL_INSTALL_LOCATION=${STAGING_DIR_HOST}${prefix}"

do_configure_prepend() {
    # awssdk dependencies are built in separate recipe aws-cpp-sdk
    sed -i 's@^add_subdirectory(awssdk)@##add_subdirectory(awssdk)@g' ${S}/CMakeLists.txt
    sed -i '/^add_dependencies.*AWS_SDK_IMPORT)/d' ${S}/CMakeLists.txt
    # install doesn't respect set EXTERNAL_INSTALL_LOCATION
    sed -i 's@${PROJECT_BINARY_DIR}/external/${CMAKE_INSTALL_LIBDIR}@${STAGING_DIR_HOST}${libdir}@g' ${S}/CMakeLists.txt
}
