package com.hust.monitor_tuning.btrace;
import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

@BTrace
public class PrintConstructor {
	
	@OnMethod(
	        clazz="com.hust.monitor_tuning.monitortools.User",
	        method="<init>"
	)
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] args) {
		BTraceUtils.println(pcn+","+pmn);
		BTraceUtils.printArray(args);
		BTraceUtils.println();
    }
}
