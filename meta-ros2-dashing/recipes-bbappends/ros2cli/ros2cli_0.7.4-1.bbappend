# Copyright (c) 2019 LG Electronics, Inc.

# Needed to run ros2 commands on the target.
RDEPENDS_${PN} += " \
    ${PYTHON_PN}-codecs \
    ${PYTHON_PN}-debugger \
    ${PYTHON_PN}-json \
    ${PYTHON_PN}-misc \
    ${PYTHON_PN}-pydoc \
    ${PYTHON_PN}-pyparsing \
    ${PYTHON_PN}-pyyaml \
    ${PYTHON_PN}-xmlrpc \
    ${PYTHON_PN}-typing \
    rosidl-generator-py \
"
