# Copyright (c) 2019 LG Electronics, Inc.

PACKAGECONFIG ??= "suitesparse cxsparse lapack"

# Backport PACKAGECONFIGs from
# http://lists.openembedded.org/pipermail/openembedded-devel/2019-September/201664.html
PACKAGECONFIG[suitesparse] = "-DSUITESPARSE=ON,-DSUITESPARSE=OFF,suitesparse-config suitesparse-amd suitesparse-camd suitesparse-colamd suitesparse-ccolamd suitesparse-cholmod suitesparse-metis suitesparse-spqr"
PACKAGECONFIG[cxsparse] = "-DCXSPARSE=ON,-DCXSPARSE=OFF,suitesparse-cxsparse"
PACKAGECONFIG[lapack] = "-DLAPACK=ON,-DLAPACK=OFF,lapack"

# Backport sstate fix from:
# http://lists.openembedded.org/pipermail/openembedded-devel/2019-September/201663.html
# We don't want path to eigen3 in ceres-solver RSS to be
# used by components which use CeresConfig.cmake from their
# own RSS
# ceres-solver/1.14-r0/packages-split/ceres-solver-dev/usr/lib/cmake/Ceres/CeresConfig.cmake:  set(Eigen3_DIR ceres-solver/1.14-r0/recipe-sysroot/usr/share/eigen3/cmake)
# ceres-solver/1.14-r0/packages-split/ceres-solver-dev/usr/lib/cmake/Ceres/CeresConfig.cmake:  list(APPEND EIGEN_INCLUDE_DIR_HINTS ceres-solver/1.14-r0/recipe-sysroot/usr/include/eigen3)
# ceres-solver/1.14-r0/packages-split/ceres-solver-dev/usr/lib/cmake/Ceres/CeresConfig.cmake:    set(glog_DIR ceres-solver/1.14-r0/recipe-sysroot/usr/lib/cmake/glog)
SSTATE_SCAN_FILES += "*.cmake"
