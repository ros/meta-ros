# Copyright (c) 2019 LG Electronics, Inc.

PACKAGECONFIG ??= "suitesparse cxsparse lapack"

PACKAGECONFIG[suitesparse] = "-DSUITESPARSE=ON,-DSUITESPARSE=OFF,suitesparse-config suitesparse-amd suitesparse-camd suitesparse-colamd suitesparse-ccolamd suitesparse-cholmod suitesparse-metis suitesparse-spqr"
PACKAGECONFIG[cxsparse] = "-DCXSPARSE=ON,-DCXSPARSE=OFF,suitesparse-cxsparse"
PACKAGECONFIG[lapack] = "-DLAPACK=ON,-DLAPACK=OFF,lapack"
