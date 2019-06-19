package com.hust.monitor_tuning.btrace;
import java.lang.reflect.Field;

import com.hust.monitor_tuning.monitortools.User;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

@BTrace
public class PrintArgComplex {
	
	
	@OnMethod(
	        clazz="com.hust.monitor_tuning.btrace.BtraceController",
	        method="arg2",
	        location=@Location(Kind.ENTRY)
	)
	// note: args must inport User ,because User not in JDK
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, User user) {
		
		//print all fields
		BTraceUtils.printFields(user);
		//print one field
		Field filed2 = BTraceUtils.field("com.hust.monitor_tuning.monitortools.User", "name");
		BTraceUtils.println(BTraceUtils.get(filed2, user));
		BTraceUtils.println(pcn+","+pmn);
		BTraceUtils.println();
    }
}
