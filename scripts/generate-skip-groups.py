#!/usr/bin/env python3

import sys
import ast
import pprint

MISSING_STR = "Missing or unbuildable dependency chain was:"
DEV_SUFFIX = "-dev"
RDEPENDS_STR = "RDEPENDS:${PN}:remove = \"${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', '%s', '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_%s}', '', d)}\""
DEPENDING_ON_STR = "ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_%s = \" \\"
UNRESOLVED_STR = "ROS_UNRESOLVED_DEP-"

def usage():
    print("generate-skip-groups.py <cooker log file>")

def main():
    if (len(sys.argv) != 2):
        usage()

    skip_groups = {}
    unresolved = []
    with open(sys.argv[1]) as cooker_log_file:
        for line in cooker_log_file:
            if line.startswith(MISSING_STR):
               chain = line.split(':', 2)[1].rstrip()
               x = ast.literal_eval(chain)

               # print(" -> ".join(x))
               # print(x[0], " : ", x[-1])

               # if either the dependendee or depender is a dev package
               if x[0].endswith(DEV_SUFFIX) or x[-1].endswith(DEV_SUFFIX):
                   continue

               if x[-1] in skip_groups:
                   # if the missing recipe has been seen already
                   if x[0] not in skip_groups[x[-1]]:
                     # add the new depender to the list
                     skip_groups[x[-1]].append(x[0])
               else:
                   # if the missing recipe is new
                   # print("DEBUG: x[0]:%s,x[-1]:%s" % (x[0],x[-1]))
                   if x[0].startswith(UNRESOLVED_STR):
                     # print("ERROR: The ROS package could not be resolved %s" % x[0])
                     unresolved.append(x[0])
                   else:
                     skip_groups[x[-1]] = [x[0]]

    if (len(unresolved) > 0):
        print("ERROR: The following ROS packages could not be resolved in OpenEmbedded:")
        for i in unresolved:
            print("  ",i.removeprefix(UNRESOLVED_STR))
        exit(-1)

    for dependee, dependers in skip_groups.items():
        print(RDEPENDS_STR % (dependee, dependee.upper()))
        print(DEPENDING_ON_STR % dependee.upper())
        dependers.sort()
        for depender in dependers:
            print(f"    %s \\" % depender)
        print("\"")

if __name__ == "__main__":
    main()
