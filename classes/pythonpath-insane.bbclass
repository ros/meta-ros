# Allow python3-native import target's python libs. This is a hacky sortcut.
#
# Interfaces and msgs generation involves importing rosidl_typesupport python
# libraries. But those libraries have their own dependency on a RMW implementation
# being present. The package rmw-fastrtps-cpp which provides such implementation
# also brings in dependency on rosidl-typesupport-introspecion-cpp.
# This rosidl-typesupport-introspecion-cpp being present automatically
# (through CMake-based mechanism) runs a python script importing modules from
# that package.
# If we make native versions of all these packages then we'll end up with
# a build dependency on asio-native which doesn't exist.
export PYTHONPATH="${STAGING_DIR_HOST}${libdir}/${PYTHON_DIR}/site-packages"
