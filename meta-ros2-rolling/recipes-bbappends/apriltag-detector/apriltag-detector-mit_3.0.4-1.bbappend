# | .../apriltag-detector/3.0.4-1/recipe-sysroot/opt/ros/rolling/include/rosidl_runtime_cpp/rosidl_runtime_cpp/traits.hpp:132:8: error: 'template<class _Codecvt, class _Elem, class _Wide_alloc, class _Byte_alloc> class std::__cxx11::wstring_convert' is deprecated [-Werror=deprecated-declarations]
# |   132 |   std::wstring_convert<std::codecvt_utf8_utf16<char16_t>, char16_t> convert;
CXXFLAGS += "-Wno-error=deprecated-declarations"


# .../apriltag-detector-mit/3.0.4-1/recipe-sysroot/usr/include/eigen3/Eigen/src/Core/arch/AVX/PacketMath.h: In function 'Eigen::internal::Packet8bf Eigen::internal::F32ToBf16(const Packet8f&)':
# .../apriltag-detector-mit/3.0.4-1/recipe-sysroot/usr/include/eigen3/Eigen/src/Core/arch/AVX/PacketMath.h:1289:13: error: unused variable 'r' [-Werror=unused-variable]
#  1289 |   Packet8bf r;
CXXFLAGS += "-Wno-error=unused-variable"
