# Copyright (c) 2020 LG Electronics, Inc.

# Fails with webOS OSE which by default uses -Werror=return-type
# plansys2-domain-expert/0.0.5-1-r0/git/src/plansys2_domain_expert/Types.cpp:131:44: error: control reaches end of non-void function [-Werror=return-type]
#   std::string wexpr = getReducedString(expr);
#                                            ^
CXXFLAGS += "-Wno-error=return-type"
