/**
 *  虚拟机性能监控
 *  
 * （1）MemoryController ：jmap+Mat 演示堆内存溢出和非堆内存溢出 
 * 	 如何导出内存映像文件：
 * 		1. 内存溢出时自动导出 -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./
 * 		2.jmap导出：jmap -dump:format=b,file=heap.hprof 16892
 * 
 * (2) CpuController : jstack 演示死锁与死循环导致CPU负载过高
 * 
 */
/**
 * @author libin
 *
 */
package com.hust.monitor_tuning.monitortools;