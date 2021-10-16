# Copyright (c) 2021 LG Electronics, Inc.

# ERROR: drone-circuit-assets-1.4.2-1-r0 do_package: QA Issue: drone-circuit-assets: Files/directories were installed but not shipped in any package:
#   /usr/opt/ros/noetic/gazebo
#   /usr/opt/ros/noetic/gazebo/assets-setup.sh
#   /usr/opt/ros/noetic/gazebo/worlds
#   /usr/opt/ros/noetic/gazebo/launch
#   /usr/opt/ros/noetic/gazebo/worlds/montmelo_line_drone.world
#   /usr/opt/ros/noetic/gazebo/worlds/nurburgring_line_drone.world
#   /usr/opt/ros/noetic/gazebo/worlds/many_curves_drone.world
#   /usr/opt/ros/noetic/gazebo/worlds/montreal_line_drone.world
#   /usr/opt/ros/noetic/gazebo/worlds/simple_circuit_drone.world
#   /usr/opt/ros/noetic/gazebo/launch/many_curves_drone.launch
#   /usr/opt/ros/noetic/gazebo/launch/simple_circuit_drone.launch
#   /usr/opt/ros/noetic/gazebo/launch/nurburgring_line_drone.launch
#   /usr/opt/ros/noetic/gazebo/launch/montreal_line_drone.launch
#   /usr/opt/ros/noetic/gazebo/launch/montmelo_line_drone.launch
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# drone-circuit-assets: 14 installed and not shipped files. [installed-vs-shipped]
FILES:${PN} += "${ros_prefix}/gazebo"
