# Copyright (c) 2022 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
  git://github.com/pboettch/json-schema-validator.git;name=upstream;destsuffix=git/nlohmann_json_schema_validator;branch=main;protocol=https \
  file://0001-CMakeLists.txt-fetch-source-with-bitbake-fetcher.patch \
"

SRCREV_upstream = "27fc1d094503623dfe39365ba82581507524545c"
EXTRA_OECMAKE += "-Dnlohmann_json_DIR=${STAGING_INCDIR}"

FILES:${PN}-dev += "${libdir}/libnlohmann_json_schema_validator.so"
