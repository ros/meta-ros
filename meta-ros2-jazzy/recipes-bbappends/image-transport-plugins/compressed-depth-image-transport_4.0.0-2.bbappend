#Copyright (c) 2024 Qualcomm Innovation Center, Inc. All rights reserved.

#warning: unused parameter 'message_info' [-Wunused-parameter]
CXXFLAGS += "-Wno-error=unused-parameter"

#error: format not a string literal and no format arguments [-Werror=format-security]
CXXFLAGS += " -Wno-format-security"

