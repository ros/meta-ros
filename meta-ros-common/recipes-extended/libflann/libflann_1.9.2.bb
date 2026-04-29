DESCRIPTION = "Fast Library for Approximate Nearest Neighbors"
AUTHOR = "Marius Muja and David G. Lowe"
HOMEPAGE = "http://www.cs.ubc.ca/~mariusm/index.php/FLANN/FLANN"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=395adad2339bd9ce5fef13d564a9681c"

SRCREV = "c50f296b0b27e14667d272b37acc63f949b305c4"
ROS_BRANCH ?= "branch=master"
SRC_URI = "git://github.com/mariusmuja/flann;${ROS_BRANCH};protocol=https"


inherit cmake pkgconfig

DEPENDS = " \
    hdf5 \
    lz4 \
"

PACKAGECONFIG ??= " \
    openmp \
    tests \
"

# Default OpenMP provider
PACKAGECONFIG[openmp] = "-DUSE_OPENMP=ON,-DUSE_OPENMP=OFF,openmp,"

# Alternative OpenMP provider for distros that use GCC libgomp instead of the
# openmp recipe
PACKAGECONFIG[gomp] = "-DUSE_OPENMP=ON,-DUSE_OPENMP=OFF,gcc-runtime,libgomp"

# Build the upstream test binaries
PACKAGECONFIG[tests] = "-DBUILD_TESTS=ON,-DBUILD_TESTS=OFF,,"

# Prevent it finding python
EXTRA_OECMAKE = "\
    -DBUILD_MATLAB_BINDINGS=OFF \
    -DBUILD_PYTHON_BINDINGS=OFF \
    -DUSE_MPI=ON \
    -DBUILD_CUDA_LIB=OFF \
    -DCMAKE_POLICY_VERSION_MINIMUM=3.5 \
"

# ERROR: QA Issue: File /usr/lib/pkgconfig/flann.pc in package libflann-dev contains reference to TMPDIR [buildpaths]
# ERROR: QA Issue: File /usr/lib/cmake/flann/flann-targets.cmake in package libflann-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#-L${RECIPE_SYSROOT}${libdir};##g" ${D}${libdir}/pkgconfig/flann.pc
    sed -i -e "s#${RECIPE_SYSROOT}${libdir}/##g" ${D}${libdir}/cmake/flann/flann-targets.cmake
}
