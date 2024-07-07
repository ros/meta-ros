# Copyright (c) 2019-2021 LG Electronics, Inc.

# Remove suitesparse-metis
PACKAGECONFIG[suitesparse] = "-DSUITESPARSE=ON,-DSUITESPARSE=OFF,suitesparse-config suitesparse-amd suitesparse-camd suitesparse-colamd suitesparse-ccolamd suitesparse-cholmod suitesparse-spqr"
PACKAGECONFIG ??= "suitesparse cxsparse lapack"

# Temporarily disable using Eigen Metis in ceres-solver
# https://github.com/ceres-solver/ceres-solver/issues/828
# EXTRA_OECMAKE += "-DCERES_NO_EIGEN_METIS=ON"
