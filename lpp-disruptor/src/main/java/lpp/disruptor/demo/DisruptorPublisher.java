/**
* 文件名：DisruptorPublisher.java
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

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import lpp.disruptor.comm.EventPublisher;

/**
 * 功能描述：
 */
public class DisruptorPublisher implements EventPublisher {
    private static final WaitStrategy YIELDING_WAIT = new YieldingWaitStrategy();
    private Disruptor<MessageEvent> disruptor = null;
    private RingBuffer<MessageEvent> ringbuffer = null;    
    private EventHandler<MessageEvent> handler = null;
    
    public DisruptorPublisher(int bufferSize) {
        handler = new MessageEventHandler();
        disruptor = new Disruptor<MessageEvent>(MessageEvent.EVENT_FACTORY, bufferSize, new ThreadFactory() {
            private  final AtomicLong THREAD_NUM = new AtomicLong(0);
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(Thread.currentThread().getThreadGroup(), r);
                thread.setName("Disruptor-Handle-Thread-"+THREAD_NUM.getAndIncrement());
                thread.setDaemon(false);
                return thread;
            }
        },  ProducerType.SINGLE, YIELDING_WAIT);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void start() {
        disruptor.handleEventsWith(handler);
        disruptor.start();
        ringbuffer = disruptor.getRingBuffer();
    }

    @Override
    public void publish(Message msg) throws Exception {
        long seq = ringbuffer.next();
        try {
            MessageEvent msgEvent = ringbuffer.get(seq);
            msgEvent.setMsg(msg);
        } finally {
            ringbuffer.publish(seq);
        }
    }

    @Override
    public void stop() {
        disruptor.shutdown();
        ringbuffer = null;
    }

}
