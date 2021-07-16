# Copyright (c) 2019 LG Electronics, Inc.

# "joy" builds fine without this dependency.
DEPENDS:remove = "joystick"
RDEPENDS:${PN}:remove = "joystick"
