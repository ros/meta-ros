# Copyright (c) 2020 LG Electronics, Inc.

# Fails with webOS OSE which by default uses -Werror=return-type
# async-web-server-cpp/0.0.3-r0/git/src/http_reply.cpp:278:1: error: no return statement in function returning non-void [-Werror=return-type]
# async-web-server-cpp/0.0.3-r0/git/src/http_reply.cpp:355:1: error: control reaches end of non-void function [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
