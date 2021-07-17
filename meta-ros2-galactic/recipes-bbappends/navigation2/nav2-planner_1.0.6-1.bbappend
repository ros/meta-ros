# Copyright (c) 2021 LG Electronics, Inc.

# nav2-planner/1.0.0-2-r0/git/src/planner_server.cpp:313:5: error: format '%lu' expects argument of type 'long unsigned int', but argument 5 has type 'std::vector<geometry_msgs::msg::PoseStamped_<std::allocator<void> >, std::allocator<geometry_msgs::msg::PoseStamped_<std::allocator<void> > > >::size_type' {aka 'unsigned int'} [-Werror=format=]
# nav2-planner/1.0.0-2-r0/git/src/planner_server.cpp:401:7: error: format '%li' expects argument of type 'long int', but argument 6 has type 'std::vector<geometry_msgs::msg::PoseStamped_<std::allocator<void> >, std::allocator<geometry_msgs::msg::PoseStamped_<std::allocator<void> > > >::size_type' {aka 'unsigned int'} [-Werror=format=]
CXXFLAGS += "-Wno-error=format="
