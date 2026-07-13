# launch-ros RDEPENDS on "python3-osrf-pycommon" (via the
# ROS_UNRESOLVED_DEP mapping), but in this layer the python modules are
# packaged into ${PN} (ros_opt_prefix claims site-packages for the base
# package), leaving a declared python3-${PN} subpackage empty and
# ungenerated. Provide the alias from the package that has the content.
RPROVIDES:${PN} += "python3-osrf-pycommon"

FILES:${PN} += "${datadir}/ament_index/resource_index/packages/osrf_pycommon"

BBCLASSEXTEND = "native nativesdk"
