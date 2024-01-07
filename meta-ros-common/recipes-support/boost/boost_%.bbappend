# Copyright (c) 2023 Wind River Systems, Inc.

inherit python3native

DEPENDS += "python3-numpy-native"

FILES:${PN}-python = " \
    ${libdir}/libboost_python*.so.* \
    ${libdir}/libboost_numpy*.so.* \
"

do_configure() {
        cd ${S}
        cp -f ${S}/boost/config/platform/linux.hpp ${S}/boost/config/platform/linux-gnueabi.hpp

        # D2194:Fixing the failure of "error: duplicate initialization of gcc with the following parameters" during compilation.
        rm -f ${WORKDIR}/user-config.jam
        echo 'using gcc : : ${CXX} : <cflags>"${CFLAGS}" <cxxflags>"${CXXFLAGS}" <linkflags>"${LDFLAGS}" ;' >> ${WORKDIR}/user-config.jam

        # If we want Python then we need to tell Boost *exactly* where to find it
        if ${@bb.utils.contains('BOOST_LIBS', 'python', 'true', 'false', d)}; then
                echo "using python : ${PYTHON_BASEVERSION} : ${STAGING_DIR_NATIVE}${bindir}/python3-native/python3 : ${STAGING_DIR_HOST}${includedir}/${PYTHON_DIR}${PYTHON_ABI} : ${STAGING_DIR_HOST}${libdir}/${PYTHON_DIR} ;" >> ${WORKDIR}/user-config.jam
        fi

        if ${@bb.utils.contains('BOOST_LIBS', 'mpi', 'true', 'false', d)}; then
                echo "using mpi : : <find-shared-library>mpi ;" >> ${WORKDIR}/user-config.jam
        fi

        CC="${BUILD_CC}" CFLAGS="${BUILD_CFLAGS}" ./bootstrap.sh --with-bjam=b2 --with-toolset=gcc

        # Boost can't be trusted to find Python on it's own, so remove any mention
        # of it from the boost configuration
        sed -i '/using python/d' ${S}/project-config.jam
}
