# Recipes in meta-ros-common that need something this layer cannot provide on its own: a layer that is
# optional (meta-qt5, meta-qt6, meta-python-ai) or a restricted license. Each is skipped through a
# ROS_WORLD_SKIP_GROUPS group, the same mechanism the distro layers use, so that "bitbake world" with
# only meta-ros-common added to oe-core and meta-oe has nothing with unresolved dependencies.
# The group names match the ones the distro layers define; adding a group twice is harmless.

ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains_any('LICENSE_FLAGS_ACCEPTED', ['commercial', 'ffmpeg', 'commercial_ffmpeg'], '', 'ffmpeg', d)}"
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', '', 'qt5', d)}"
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt6-layer', '', 'qt6', d)}"
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'meta-python-ai', '', 'blosc', d)}"
# urdfdom (needed by dartsim) is only provided by the ROS distro layers
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains_any('BBFILE_COLLECTIONS', 'ros1-noetic-layer ros2-humble-layer ros2-jazzy-layer ros2-kilted-layer ros2-lyrical-layer ros2-rolling-layer spaceros-jazzy-layer', '', 'urdfdom', d)}"

# ffmpeg is built with LICENSE_FLAGS "commercial"
SKIP_RECIPE[gz-common] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ffmpeg', 'ffmpeg: depends on ffmpeg which has a restricted license not whitelisted in LICENSE_FLAGS_ACCEPTED', '', d)}"
SKIP_RECIPE[gz-common5] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ffmpeg', 'ffmpeg: depends on ffmpeg which has a restricted license not whitelisted in LICENSE_FLAGS_ACCEPTED', '', d)}"
SKIP_RECIPE[gz-common6] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ffmpeg', 'ffmpeg: depends on ffmpeg which has a restricted license not whitelisted in LICENSE_FLAGS_ACCEPTED', '', d)}"
SKIP_RECIPE[ignition-common3] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ffmpeg', 'ffmpeg: depends on ffmpeg which has a restricted license not whitelisted in LICENSE_FLAGS_ACCEPTED', '', d)}"
SKIP_RECIPE[ignition-common4] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'ffmpeg', 'ffmpeg: depends on ffmpeg which has a restricted license not whitelisted in LICENSE_FLAGS_ACCEPTED', '', d)}"

# Qt 5 from meta-qt5
SKIP_RECIPE[gz-gui8] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'qt5: depends on qtbase from meta-qt5', '', d)}"
SKIP_RECIPE[gz-gui9] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'qt5: depends on qtbase from meta-qt5', '', d)}"
SKIP_RECIPE[ignition-gui6] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'qt5: depends on qtbase from meta-qt5', '', d)}"

# Qt 6 from meta-qt6
SKIP_RECIPE[gz-gui] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt6', 'qt6: depends on qtbase from meta-qt6', '', d)}"

# blosc is in meta-python-ai
SKIP_RECIPE[openvdb] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'blosc', 'blosc: depends on blosc from meta-python-ai', '', d)}"

# Recipes that depend on the ones above (or, for dartsim, on urdfdom)
SKIP_RECIPE[dartsim] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['urdfdom'], 'urdfdom: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[gz-fuel-tools] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg'], 'ffmpeg: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[gz-fuel-tools9] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg'], 'ffmpeg: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[gz-fuel-tools10] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg'], 'ffmpeg: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[ignition-fuel-tools4] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg'], 'ffmpeg: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[ignition-fuel-tools7] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg'], 'ffmpeg: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[gz-rendering] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg'], 'ffmpeg: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[gz-rendering8] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg'], 'ffmpeg: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[gz-rendering9] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg'], 'ffmpeg: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[ignition-rendering6] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg'], 'ffmpeg: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[gz-sensors] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg'], 'ffmpeg: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[gz-sensors8] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg'], 'ffmpeg: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[gz-sensors9] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg'], 'ffmpeg: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[ignition-sensors6] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg'], 'ffmpeg: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[gz-physics] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg', 'urdfdom'], 'ffmpeg/urdfdom: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[gz-physics7] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg', 'urdfdom'], 'ffmpeg/urdfdom: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[gz-physics8] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg', 'urdfdom'], 'ffmpeg/urdfdom: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[ignition-physics5] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg', 'urdfdom'], 'ffmpeg/urdfdom: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[gz-launch] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg', 'qt6'], 'ffmpeg/qt6: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[gz-launch7] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg', 'qt5'], 'ffmpeg/qt5: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[gz-launch8] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg', 'qt5'], 'ffmpeg/qt5: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[ignition-launch5] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg', 'qt5'], 'ffmpeg/qt5: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[gz-sim] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg', 'qt6', 'urdfdom'], 'ffmpeg/qt6/urdfdom: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[gz-sim8] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg', 'qt5', 'urdfdom'], 'ffmpeg/qt5/urdfdom: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[gz-sim9] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg', 'qt5', 'urdfdom'], 'ffmpeg/qt5/urdfdom: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[ignition-gazebo6] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg', 'qt5', 'urdfdom'], 'ffmpeg/qt5/urdfdom: depends on something that is not available (see above)', '', d)}"
SKIP_RECIPE[gazebo11] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['ffmpeg', 'qt5'], 'ffmpeg/qt5: depends on something that is not available (see above)', '', d)}"
