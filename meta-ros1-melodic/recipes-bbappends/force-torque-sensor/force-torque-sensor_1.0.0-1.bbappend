# Copyright (c) 2020 LG Electronics, Inc.

# Fails with webOS OSE which by default uses -Werror=return-type
# force-torque-sensor/1.0.0-1-r0/git/src/force_torque_sensor_sim.cpp:20:1: error: no return statement in function returning non-void [-Werror=return-type]
# force-torque-sensor/1.0.0-1-r0/git/src/force_torque_sensor_sim.cpp:24:1: error: no return statement in function returning non-void [-Werror=return-type]
# force-torque-sensor/1.0.0-1-r0/git/src/force_torque_sensor_sim.cpp:49:1: error: no return statement in function returning non-void [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
