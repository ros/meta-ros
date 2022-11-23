# Copyright (c) 2022 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
  git://github.com/pboettch/json-schema-validator.git;name=upstream;destsuffix=git/nlohmann_json_schema_validator;branch=main;protocol=https \
  file://0001-CMakeLists.txt-fetch-source-with-bitbake-fetcher.patch \
"

SRCREV_upstream = "1063c9adbafc25f5a14bae15c3babdb039de86c6"
EXTRA_OECMAKE += "-Dnlohmann_json_DIR=${STAGING_INCDIR}"

FILES:${PN}-dev += "${libdir}/libnlohmann_json_schema_validator.so"

# Doesn't need runtime dependency on nlohmann-json
ROS_EXEC_DEPENDS:remove = "nlohmann-json"
