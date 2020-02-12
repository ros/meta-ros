# Copyright (c) 2019 LG Electronics, Inc.

inherit ros_insane_dev_so

# Ignore this for now
# | /jenkins/mjansa/build-ros-thud-mcf-herb/artifacts/BUILD-ros2-eloquent-thud.mcf/work/i586-oe-linux/ecl-command-line/1.0.4-1-r0/git/src/examples/../../include/ecl/command_line/cmd_line.hpp: In member function 'virtual void ecl::CmdLine::parse(int, char**)':
# | /jenkins/mjansa/build-ros-thud-mcf-herb/artifacts/BUILD-ros2-eloquent-thud.mcf/work/i586-oe-linux/ecl-command-line/1.0.4-1-r0/git/src/examples/../../include/ecl/command_line/cmd_line.hpp:410:25: error: catching polymorphic type 'class ecl::ArgException' by value [-Werror=catch-value=]
# |   } catch ( ArgException e ) { _output->failure(*this,e); exit(1); }
# |                          ^
CXXFLAGS += "-Wno-error=catch-value="
