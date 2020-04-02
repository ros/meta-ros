# Copyright (c) 2020 LG Electronics, Inc.

# psen-scan/1.0.4-1-r0/git/src/scanner_frames.cpp:41:10: error: 'char* strncpy(char*, const char*, size_t)' specified bound 8 equals destination size [-Werror=stringop-truncation]
# psen-scan/1.0.4-1-r0/git/src/scanner_frames.cpp:58:10: error: 'char* strncpy(char*, const char*, size_t)' specified bound 8 equals destination size [-Werror=stringop-truncation]
CXXFLAGS += "-Wno-error=stringop-truncation"
