# Copyright (c) 2019-2021 LG Electronics, Inc.

# Remove suitesparse-metis
PACKAGECONFIG[suitesparse] = "-DSUITESPARSE=ON,-DSUITESPARSE=OFF,suitesparse-config suitesparse-amd suitesparse-camd suitesparse-colamd suitesparse-ccolamd suitesparse-cholmod suitesparse-spqr"
# suitesparse and lapack need Fortran support (ros-common-layer/ros/fortran fragment); without it
# ceres-solver builds with Eigen only.
PACKAGECONFIG ??= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'fortran', '', 'suitesparse cxsparse lapack', d)}"

# Temporarily disable using Eigen Metis in ceres-solver
# https://github.com/ceres-solver/ceres-solver/issues/828
# EXTRA_OECMAKE += "-DCERES_NO_EIGEN_METIS=ON"

# QA Issue: File /usr/lib/cmake/Ceres/CeresTargets.cmake
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}/usr/lib/##g" ${D}/usr/lib/cmake/Ceres/CeresTargets.cmake
}
