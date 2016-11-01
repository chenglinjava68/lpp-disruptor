/**
* 文件名：Clent.java
* 创建日期： 2016年11月1日
* 作者：     lipanpan
* Copyright (c) 2009-2011 无线开发室
* All rights reserved.
 
* 修改记录：
* 	1.修改时间：2016年11月1日
*   修改人：lipanpan
*   修改内容：
*/
package lpp.disruptor.demo;

import java.util.concurrent.atomic.AtomicLong;

import lpp.disruptor.comm.EventPublisher;

/**
 * 功能描述：客戶端测试代码
 */
public class Client {
    private static AtomicLong MSG_ID = new AtomicLong(0);
    public static void main(String[] args) throws Exception {
        EventPublisher publisher = new DisruptorPublisher(2<<3);
        publisher.start();
        Message msg = null;
        for(int i=0;i<1000000;i++){
            msg = new Message();
            msg.setCmd((byte)1);
            msg.setMsgId(MSG_ID.getAndIncrement());
            msg.setContent("msgId content...");
            publisher.publish(msg);  
        }
        publisher.stop();
    }

}
