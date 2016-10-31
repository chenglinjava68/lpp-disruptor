/**
* 文件名：EventPublisher.java
* 创建日期： 2016年11月1日
* 作者：     lipanpan
* Copyright (c) 2009-2011 无线开发室
* All rights reserved.
 
* 修改记录：
* 	1.修改时间：2016年11月1日
*   修改人：lipanpan
*   修改内容：
*/
package lpp.disruptor.comm;

import lpp.disruptor.demo.Message;

/**
 * 功能描述：
 */
public interface EventPublisher {
    
    void start();
    
    void publish(Message msg) throws Exception;
    
    void stop();

}
