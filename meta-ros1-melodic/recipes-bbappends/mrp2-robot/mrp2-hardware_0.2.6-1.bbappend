# Copyright (c) 2020 LG Electronics, Inc.

# Fails with webOS OSE which by default uses -Werror=return-type
# mrp2-hardware/0.2.6-1-r0/git/src/mrp2_serial.cpp:401:1: error: control reaches end of non-void function [-Werror=return-type]
# mrp2-hardware/0.2.6-1-r0/git/src/mrp2_serial.cpp:627:1: error: control reaches end of non-void function [-Werror=return-type]
# mrp2-hardware/0.2.6-1-r0/git/src/serial_comm.cpp:220:1: error: no return statement in function returning non-void [-Werror=return-type]
# mrp2-hardware/0.2.6-1-r0/git/src/serial_comm.cpp:232:1: error: no return statement in function returning non-void [-Werror=return-type]
# mrp2-hardware/0.2.6-1-r0/git/src/serial_comm.cpp:247:1: error: no return statement in function returning non-void [-Werror=return-type]
# mrp2-hardware/0.2.6-1-r0/git/src/serial_comm.cpp:252:1: error: no return statement in function returning non-void [-Werror=return-type]
# mrp2-hardware/0.2.6-1-r0/git/src/serial_comm.cpp:257:1: error: no return statement in function returning non-void [-Werror=return-type]
# mrp2-hardware/0.2.6-1-r0/git/src/usb_comm.cpp:115:1: error: no return statement in function returning non-void [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
