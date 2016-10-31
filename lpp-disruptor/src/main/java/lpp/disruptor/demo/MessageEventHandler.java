/**
* 文件名：MessageEventHandler.java
* 创建日期： 2016年10月31日
* 作者：     lipanpan
* Copyright (c) 2009-2011 无线开发室
* All rights reserved.
 
* 修改记录：
* 	1.修改时间：2016年10月31日
*   修改人：lipanpan
*   修改内容：
*/
package lpp.disruptor.demo;

import com.lmax.disruptor.EventHandler;

/**
 * 功能描述：消息处理器
 */
public class MessageEventHandler implements EventHandler<MessageEvent> {

    @Override
    public void onEvent(MessageEvent event, long sequence, boolean endOfBatch) throws Exception {
        Message msg = event.getMsg();
        System.out.println(msg.toString());
    }

}
