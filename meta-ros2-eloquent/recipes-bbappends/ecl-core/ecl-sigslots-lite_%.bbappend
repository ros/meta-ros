# Copyright (c) 2021 LG Electronics, Inc.

# /jenkins/mjansa/build/ose/honister/BUILD/work/qemux86-webos-linux/ecl-sigslots-lite/1.0.6-1-r0/git/src/examples/../../include/ecl/sigslots_lite/managers.hpp: In static member function 'static ecl::lite::sigslots::GlobalSlot<Data>* ecl::lite::GlobalSlots<Data, Dummy>::addSlot(void (*)(Data))':
# /jenkins/mjansa/build/ose/honister/BUILD/work/qemux86-webos-linux/ecl-sigslots-lite/1.0.6-1-r0/git/src/examples/../../include/ecl/sigslots_lite/managers.hpp:233:51: error: ISO C++ forbids variable length array 'slots' [-Werror=vla]
#   233 |                 static sigslots::GlobalSlot<Data> slots[capacity];
#       |                                                   ^~~~~
# /jenkins/mjansa/build/ose/honister/BUILD/work/qemux86-webos-linux/ecl-sigslots-lite/1.0.6-1-r0/git/src/examples/../../include/ecl/sigslots_lite/managers.hpp: In static member function 'static ecl::lite::sigslots::GlobalSlot<void>* ecl::lite::GlobalSlots<void, Dummy>::addSlot(void (*)())':
# /jenkins/mjansa/build/ose/honister/BUILD/work/qemux86-webos-linux/ecl-sigslots-lite/1.0.6-1-r0/git/src/examples/../../include/ecl/sigslots_lite/managers.hpp:368:51: error: ISO C++ forbids variable length array 'slots' [-Werror=vla]
#   368 |                 static sigslots::GlobalSlot<void> slots[capacity];
#       |                                                   ^~~~~
CXXFLAGS += "-Wno-error=vla"
