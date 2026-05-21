PACKAGECONFIG = "lapack cblas affinity dynarch"

# Set HOSTCC so that getarch may be built when make clean is invoked in do_configure
EXTRA_OEMAKE += " HOSTCC="${BUILD_CC}" "
