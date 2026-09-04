# Copyright (c) 2023 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# see CMakeLists.txt
# keep using the FetchContent_Declare of the CMakeFiles.txt
# But modify the external URL (https://github.com) to a local file
EXTRA_OECMAKE += "-DFETCHCONTENT_FULLY_DISCONNECTED=OFF"

SRC_URI += " \
    file://0001-disable-fetch-in-compile-step.patch \
    https://github.com/foxglove/foxglove-sdk/releases/download/sdk/v0.19.0/foxglove-v0.19.0-cpp-aarch64-unknown-linux-gnu.zip;name=aarch64;unpack=0;subdir=${BP} \
    https://github.com/foxglove/foxglove-sdk/releases/download/sdk/v0.19.0/foxglove-v0.19.0-cpp-x86_64-unknown-linux-gnu.zip;name=x86_64;unpack=0;subdir=${BP} \
"

SRC_URI[aarch64.sha256sum] = "7b1a7911f4cdf491ea6d38486af6f730ab3c90d4e54071a85bb887994424e51b"
SRC_URI[x86_64.sha256sum] = "f3d2f6a8ba97fedeae13b978f5e8a51dec4803eddfd23b198a292bf9ab6675ff"

# foxglove-bridge/0.7.2-1-r0/recipe-sysroot/usr/include/rclcpp/rclcpp/any_subscription_callback.hpp:391:21: error: 'void rclcpp::AnySubscriptionCallback<MessageT, AllocatorT>::set_deprecated(std::function<void(std::shared_ptr<_Yp>)>) [with SetT = rosgraph_msgs::msg::Clock_<std::allocator<void> >; MessageT = rosgraph_msgs::msg::Clock_<std::allocator<void> >; AllocatorT = std::allocator<void>]' is deprecated: use 'void(std::shared_ptr<const MessageT>)' instead [-Werror=deprecated-declaratio
CXXFLAGS += "-Wno-error=deprecated-declarations"

# foxglove-bridge/3.2.6-1/recipe-sysroot/opt/ros/rolling/include/rosx_introspection/details/conversion_impl.hpp:158:12: warning: comparing floating-point with '==' or '!=' is unsafe [-Wfloat-equal]
CXXFLAGS += "-Wno-error=float-equal"

# foxglove-bridge/3.2.6-1/recipe-sysroot/opt/ros/rolling/include/rosx_introspection/contrib/SmallVector.h:1161:34: error: use of old-style cast to 'char*' [-Werror=old-style-cast]
CXXFLAGS += "-Wno-error=old-style-cast"
