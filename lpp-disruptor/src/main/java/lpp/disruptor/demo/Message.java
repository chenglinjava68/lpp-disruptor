/**
* 文件名：Message.java
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

import java.io.Serializable;

/**
 * 功能描述：消息
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 6430085369948672161L;
    private Byte cmd = null;
}
