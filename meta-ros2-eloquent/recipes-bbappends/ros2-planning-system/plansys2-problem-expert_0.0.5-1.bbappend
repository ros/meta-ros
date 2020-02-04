# Copyright (c) 2020 LG Electronics, Inc.

# Fails with webOS OSE which by default uses -Werror=return-type
# plansys2-problem-expert/0.0.5-1-r0/git/src/plansys2_problem_expert/ProblemExpert.cpp:273:23: error: control reaches end of non-void function [-Werror=return-type]
#          node->toString() << "]" << std::endl;
#          ~~~~~~~~~~~~~~^~
CXXFLAGS += "-Wno-error=return-type"
