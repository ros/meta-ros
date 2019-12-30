# Copyright (c) 2019 LG Electronics, Inc.

# -Werror=return-type is enabled by default in webOS OSE builds, causing:
# async-web-server-cpp/1.0.0-1-r0/git/src/http_reply.cpp: In member function 'bool async_web_server_cpp::FilesystemHttpRequestHandler::operator()(const async_web_server_cpp::HttpRequest&, boost::shared_ptr<async_web_server_cpp::HttpConnection>, const char*, const char*)':
# async-web-server-cpp/1.0.0-1-r0/git/src/http_reply.cpp:355:1: error: control reaches end of non-void function [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
