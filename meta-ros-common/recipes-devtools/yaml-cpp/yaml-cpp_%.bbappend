EXTRA_OECMAKE += " -DYAML_CPP_BUILD_CONTRIB=OFF"

PACKAGES =+ "${PN}-gtest"
FILES:${PN}-gtest += " \
    ${libdir}/libgmock_main.so \
    ${libdir}/libgtest_main.so \
    ${libdir}/libgtest.so \
    ${libdir}/libgmock.so \
"

BBCLASSEXTEND = "native nativesdk"
