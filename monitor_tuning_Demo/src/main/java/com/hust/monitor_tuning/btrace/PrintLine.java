package com.hust.monitor_tuning.btrace;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

@BTrace
public class PrintLine {
	
	@OnMethod(
			clazz="com.hust.monitor_tuning.btrace.BtraceController",
	        method="exception",
	        location=@Location(value=Kind.LINE, line=-1)
	)
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, int line) {
		BTraceUtils.println(pcn+","+pmn + "," +line);
		BTraceUtils.println();
    }
}
