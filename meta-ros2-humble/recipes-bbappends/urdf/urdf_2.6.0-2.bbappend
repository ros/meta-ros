# Add urdf-parser-plugin at runtime to resolve issues with robot_state_publisher
#
# [robot_state_publisher-1] terminate called after throwing an instance of 'pluginlib::ClassLoaderException'
# [robot_state_publisher-1]   what():  package 'urdf_parser_plugin' not found, searching: [/usr]
ROS_EXEC_DEPENDS:append = " urdf-parser-plugin"
