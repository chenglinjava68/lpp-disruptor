/**
* 文件名：MessageEvent.java
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

import com.lmax.disruptor.EventFactory;

/**
 * 功能描述：消息事件
 */
public class MessageEvent {
    public final static  EventFactory<MessageEvent> EVENT_FACTORY = new EventFactory<MessageEvent>(){
        public MessageEvent newInstance(){
            return new MessageEvent();
        }
    };
    
    /**事件信息*/
    private Message msg = null;

    public Message getMsg() {
        return msg;
    }

    public void setMsg(Message msg) {
        this.msg = msg;
    }
    
}
