# Copyright (C) 2023 Avnet, Inc.  All rights reserved.

# v4l2-camera-0.7.1-1/src/v4l2_camera.cpp:47:69: error: 'image_transport::CameraPublisher image_transport::create_camera_publisher(rclcpp::Node*, const std::string&, rmw_qos_profile_t, rclcpp::PublisherOptions)' is deprecated: Use create_camera_publisher(RequiredInterfaces node_interfaces, ..., rclcpp::QoS, ...) instead [-Werror=deprecated-declarations]
CXXFLAGS += "-Wno-error=deprecated-declarations"
