# Copyright (c) 2020 LG Electronics, Inc.

# Needed to run ros2 commands on the target.
RDEPENDS:${PN} += "\
    python3-codecs \
    python3-debugger \
    python3-json \
    python3-misc \
    python3-netifaces \
    python3-pydoc \
    python3-pyparsing \
    python3-pyyaml \
    python3-xmlrpc \
    rosidl-generator-py \
"
