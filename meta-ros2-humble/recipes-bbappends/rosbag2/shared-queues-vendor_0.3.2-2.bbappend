# Copyright (c) 2020 LG Electronics, Inc.

# Instead of fetching
# https://github.com/cameron314/readerwriterqueue/archive/ef7dfbf553288064347d51b8ac335f1ca489032a.zip
# https://github.com/cameron314/concurrentqueue/archive/8f65a8734d77c3cc00d74c0532efca872931d3ce.zip
# with curl during do_compile use bitbake git fetcher
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fetch-readerwriterqueue-and-concurren.patch \
    git://github.com/cameron314/readerwriterqueue.git;protocol=https;name=singleproducerconsumer-upstream;destsuffix=git/singleproducerconsumer-upstream \
    git://github.com/cameron314/concurrentqueue.git;protocol=https;name=concurrentqueue-upstream;destsuffix=git/concurrentqueue-upstream \
"
SRCREV_singleproducerconsumer-upstream = "ef7dfbf553288064347d51b8ac335f1ca489032a"
SRCREV_concurrentqueue-upstream = "8f65a8734d77c3cc00d74c0532efca872931d3ce"
