#!/bin/sh
#
# Copyright (c) 2014, BMW Car IT GmbH
#
# Permission is hereby granted, free of charge, to any person obtaining a copy
# of this software and associated documentation files (the "Software"), to
# deal in the Software without restriction, including without limitation the
# rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
# sell copies of the Software, and to permit persons to whom the Software is
# furnished to do so, subject to the following conditions:
#
# The above copyright notice and this permission notice shall be included in
# all copies or substantial portions of the Software.
#
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
# FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
# IN THE SOFTWARE.
#

violation_found=no
for patch_file in $(find $1 -name \*.patch)
do
    if [ "$(grep 'Upstream-Status: ' $patch_file | wc -l)" -eq "0" ]; then
        echo "$patch_file: missing Upstream-Status line"
        violation_found=yes
    fi
    if [ "$(grep -d skip "file://$(basename $patch_file)" $(dirname $patch_file)/../* | wc -l)" -eq "0" ]; then
        echo "$patch_file: not used in any recipe"
        violation_found=yes
    fi
done

if [ "$violation_found" = "yes" ]; then
    exit 1
fi
