# Copyright (c) 2020 LG Electronics, Inc.

# ecl-core-apps/1.0.4-1-r0/git/src/benchmarks/eigen3_decompositions.cpp:196:52: error: array subscript 40 is outside array bounds of 'ecl::TimeStamp [13]' [-Werror=array-bounds]
# ecl-core-apps/1.0.4-1-r0/git/src/benchmarks/eigen3_decompositions.cpp:196:52: error: array subscript 41 is outside array bounds of 'ecl::TimeStamp [13]' [-Werror=array-bounds]
# ecl-core-apps/1.0.4-1-r0/git/src/benchmarks/eigen3_transforms.cpp:124:4: error: implicitly-declared 'constexpr Pose2D& Pose2D::operator=(const Pose2D&)' is deprecated [-Werror=deprecated-copy]
# ecl-core-apps/1.0.4-1-r0/git/src/benchmarks/eigen3_transforms.cpp:125:4: error: implicitly-declared 'constexpr Pose2D& Pose2D::operator=(const Pose2D&)' is deprecated [-Werror=deprecated-copy]
# ecl-core-apps/1.0.4-1-r0/git/src/benchmarks/eigen3_transforms.cpp:126:4: error: implicitly-declared 'constexpr Pose2D& Pose2D::operator=(const Pose2D&)' is deprecated [-Werror=deprecated-copy]
# ecl-core-apps/1.0.4-1-r0/git/src/benchmarks/eigen3_transforms.cpp:133:4: error: implicitly-declared 'constexpr Pose2D& Pose2D::operator=(const Pose2D&)' is deprecated [-Werror=deprecated-copy]
# ecl-core-apps/1.0.4-1-r0/git/src/benchmarks/eigen3_transforms.cpp:134:4: error: implicitly-declared 'constexpr Pose2D& Pose2D::operator=(const Pose2D&)' is deprecated [-Werror=deprecated-copy]
# ecl-core-apps/1.0.4-1-r0/git/src/benchmarks/eigen3_transforms.cpp:135:4: error: implicitly-declared 'constexpr Pose2D& Pose2D::operator=(const Pose2D&)' is deprecated [-Werror=deprecated-copy]
# ecl-core-apps/1.0.4-1-r0/git/src/benchmarks/eigen3_transforms.cpp:144:6: error: implicitly-declared 'constexpr Pose2D& Pose2D::operator=(const Pose2D&)' is deprecated [-Werror=deprecated-copy]
# ecl-core-apps/1.0.4-1-r0/git/src/benchmarks/eigen3_transforms.cpp:145:6: error: implicitly-declared 'constexpr Pose2D& Pose2D::operator=(const Pose2D&)' is deprecated [-Werror=deprecated-copy]
CXXFLAGS += "-Wno-error=array-bounds -Wno-error=deprecated-copy"
