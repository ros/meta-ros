# Copyright (c) 2020 LG Electronics, Inc.

# Fails with webOS OSE which by default uses gold
# photo/1.0.3-1-r0/devel/lib/libphoto2.so: error: undefined reference to 'gp_list_unref'
# photo/1.0.3-1-r0/devel/lib/libphoto2.so: error: undefined reference to 'gp_port_info_list_free'
# photo/1.0.3-1-r0/devel/lib/libphoto2.so: error: undefined reference to 'gp_abilities_list_free'
# photo/1.0.3-1-r0/devel/lib/libphoto2.so: error: undefined reference to 'gp_abilities_list_lookup_model'
# ....
CXXFLAGS += "-fuse-ld=bfd"
