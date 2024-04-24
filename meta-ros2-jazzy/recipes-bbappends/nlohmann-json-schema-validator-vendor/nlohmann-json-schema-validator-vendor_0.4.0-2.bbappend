# Copyright (c) 2022 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI = " \
  git://github.com/ros2-gbp/nlohmann_json_schema_validator_vendor-release;name=release;${ROS_BRANCH};protocol=https \
  git://github.com/pboettch/json-schema-validator.git;name=upstream;destsuffix=git/nlohmann_json_schema_validator;branch=main;protocol=https \
  file://0001-CMakeLists.txt-fetch-source-with-bitbake-fetcher.patch \
"

SRCREV_release = "f497d7a93e175c4693592f0b67999a1822666eb7"
SRCREV_upstream = "1063c9adbafc25f5a14bae15c3babdb039de86c6"
SRCREV_FORMAT = "release_upstream"

EXTRA_OECMAKE += "-Dnlohmann_json_DIR=${STAGING_INCDIR}"

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package nlohmann-json-schema-validator-vendor contains symlink .so '/usr/lib/libnlohmann_json_schema_validator.so' [dev-so]
FILES:${PN}-dev += "${libdir}/libnlohmann_json_schema_validator.so"

# Doesn't need runtime dependency on nlohmann-json
ROS_EXEC_DEPENDS:remove = "nlohmann-json"
