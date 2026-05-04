# | .../apriltag-detector/3.0.4-1/recipe-sysroot/opt/ros/rolling/include/rosidl_runtime_cpp/rosidl_runtime_cpp/traits.hpp:132:8: error: 'template<class _Codecvt, class _Elem, class _Wide_alloc, class _Byte_alloc> class std::__cxx11::wstring_convert' is deprecated [-Werror=deprecated-declarations]
# |   132 |   std::wstring_convert<std::codecvt_utf8_utf16<char16_t>, char16_t> convert;

CXXFLAGS += "-Wno-error=deprecated-declarations"
