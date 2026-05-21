PACKAGECONFIG = "lapack cblas affinity dynarch"

# Set HOSTCC so that getarch may be built when make clean is invoked in do_configure
EXTRA_OEMAKE += " HOSTCC="${BUILD_CC}" "

# gemm.c:739:53: error: passing argument 5 of 'gemm_thread_mn' from incompatible pointer type [-Wincompatible-pointer-types]
# strict function pointer type mismatch in OpenBLAS 0.3.31 when building sbgemm (bfloat16 GEMM)
EXTRA_OEMAKE += " BUILD_BFLOAT16=0"
