# Copyright (c) 2021 LG Electronics, Inc.

# catkin-ized version of grpc is already blacklisted in meta-ros1-melodic

# grpc-1.35.0 from meta-oe which was upgraded to this version in:
# https://git.openembedded.org/meta-openembedded/commit/?id=15cff67fd6cdb34e3621368fe9ce94a98356f27a
# isn't compatible with this older abseil-cpp version and fails

# abseil-cpp in meta-oe was already upgraded to compatible version (from 20190808 to 20200923) in:
# https://git.openembedded.org/meta-openembedded/commit/?id=ce9fa374e134040f60d199448340c04c89d2ec85

# but it's unclear what is relation between 0.4.2-1 catkin-ized version and "date" release tags in upstream:
# catkin-ized: https://github.com/Eurecat/abseil_cpp-release/tree/release/melodic%2Fabseil_cpp%2F0.4.2-1
# upstream: https://github.com/abseil/abseil-cpp (https://github.com/abseil/abseil-cpp/releases)
PNBLACKLIST[abseil-cpp] ?= "It is a catkin-ized edition of the upstream version that is not used by any other ROS 1 package and this one isn't compatible with grpc-1.35.0 recipe currently in meta-oe (unlike the abseil-cpp recipe for 20200923+git${SRCPV} version also in meta-oe)"
