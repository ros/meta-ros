# Copyright (c) 2020 LG Electronics, Inc.

# Fails with webOS OSE which by default uses -Werror=return-type
# force-torque-sensor/1.0.0-1-r0/git/src/force_torque_sensor_sim.cpp:20:1: error: no return statement in function returning non-void [-Werror=return-type]
# force-torque-sensor/1.0.0-1-r0/git/src/force_torque_sensor_sim.cpp:24:1: error: no return statement in function returning non-void [-Werror=return-type]
# force-torque-sensor/1.0.0-1-r0/git/src/force_torque_sensor_sim.cpp:49:1: error: no return statement in function returning non-void [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"

# Fails with webOS OSE which by default uses gold
# force-torque-sensor/1.0.0-1-r0/recipe-sysroot/usr/opt/ros/melodic/lib/libiirob_filters.so: error: undefined reference to 'void tf2::doTransform<geometry_msgs::Vector3Stamped_<std::allocator<void> > >(geometry_msgs::Vector3Stamped_<std::allocator<void> > const&, geometry_msgs::Vector3Stamped_<std::allocator<void> >&, geometry_msgs::TransformStamped_<std::allocator<void> > const&)'
# the underlinkage should be fixed in meta-ros1-melodic/generated-recipes/iirob-filters/iirob-filters_0.9.1-1.bb
# but for now just use bfd
CXXFLAGS += "-fuse-ld=bfd"
