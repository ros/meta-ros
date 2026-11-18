# Copyright (c) 2024 Wind River Systems, Inc.

# These changes only apply when lapack is used with OpenBLAS from
# meta-python-ai; they are split out of recipes-devtools/lapack so that
# adding meta-ros alone does not change the oe-core/meta-oe lapack recipe.

# Prevent lapack from building ILP64 when OpenBLAS is using LP64
# Resolves link-time errors related to missing symbols with suffix '_64_'
#   x86_64-oe-linux-ld: ../../lib/liblapack.so.3.12.0: undefined reference to `cdotc_64_'
EXTRA_OECMAKE += "\
  -DBUILD_INDEX64=OFF \
  -DBUILD_INDEX64_EXT_API=OFF \
"

# Copy do_install_ptest from oe-core but remove references to netlib BLAS
do_install_ptest () {
    rsync -a ${B}/TESTING ${D}${PTEST_PATH} \
          --exclude CMakeFiles \
          --exclude cmake_install.cmake \
          --exclude Makefile
    rsync -a ${B}/LAPACKE ${D}${PTEST_PATH} \
          --exclude CMakeFiles \
          --exclude cmake_install.cmake \
          --exclude Makefile \
          --exclude lapacke.pc
    cp -r ${B}/bin ${D}${PTEST_PATH}
    cp -r ${B}/lapack_testing.py ${D}${PTEST_PATH}
    cp ${B}/CTestTestfile.cmake ${D}${PTEST_PATH}
    cp ${S}/TESTING/*.in ${S}/TESTING/runtest.cmake ${D}${PTEST_PATH}/TESTING
    sed -i -e 's#${B}#${PTEST_PATH}#g' `find ${D}${PTEST_PATH} -name CTestTestfile.cmake`
    sed -i -e 's#${S}#${PTEST_PATH}#g' `find ${D}${PTEST_PATH} -name CTestTestfile.cmake`
    sed -i -e 's#${RECIPE_SYSROOT_NATIVE}##g' `find ${D}${PTEST_PATH} -name CTestTestfile.cmake`
    sed -i -e 's#${PYTHON}#/usr/bin/python3#g' `find ${D}${PTEST_PATH} -name CTestTestfile.cmake`
    sed -i -e 's#${WORKDIR}##g' `find ${D}${PTEST_PATH} -name CTestTestfile.cmake`
}
