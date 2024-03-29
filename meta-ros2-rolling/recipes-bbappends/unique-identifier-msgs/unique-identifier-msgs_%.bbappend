# Even though this is just a runtime dependency, it seems that
# rosidl-core-runtime which is just a group of RDEPENDS is otherwise
# not pulled in correctly at package generation and gives a lot of
# QA [file-rdeps]. Other alternative is to skip this QA.

DEPENDS:append = " \
    rosidl-core-runtime \
    service-msgs \
"
