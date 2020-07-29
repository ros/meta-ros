# Copyright (c) 2020 LG Electronics, Inc.

# Ignore this for now
# rosbag-cloud-recorders/1.0.1-1-r0/recipe-sysroot/usr/opt/ros/melodic/include/actionlib/client/goal_manager_imp.h:86:10: error: implicitly-declared 'actionlib::ManagedList<boost::shared_ptr<actionlib::CommStateMachine<file_uploader_msgs::UploadFilesAction_<std::allocator<void> > > > >::Handle::Handle(const actionlib::ManagedList<boost::shared_ptr<actionlib::CommStateMachine<file_uploader_msgs::UploadFilesAction_<std::allocator<void> > > > >::Handle&)' is deprecated [-Werror=deprecated-copy]
# rosbag-cloud-recorders/1.0.1-1-r0/recipe-sysroot/usr/opt/ros/melodic/include/actionlib/client/goal_manager_imp.h:86:10: error: implicitly-declared 'actionlib::ManagedList<boost::shared_ptr<actionlib::CommStateMachine<file_uploader_msgs::UploadFilesAction_<std::allocator<void> > > > >::Handle::Handle(const actionlib::ManagedList<boost::shared_ptr<actionlib::CommStateMachine<file_uploader_msgs::UploadFilesAction_<std::allocator<void> > > > >::Handle&)' is deprecated [-Werror=deprecated-copy]
CXXFLAGS += "-Wno-error=deprecated-copy"
