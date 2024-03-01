#Copyright (c) 2024 Qualcomm Innovation Center, Inc. All rights reserved.

do_configure:prepend() {
    if [ ! -d ${S}/.git/hooks/ ];then
        mkdir ${S}/.git/hooks/
    fi
    touch ${S}/.git/hooks/commit-msg
}
