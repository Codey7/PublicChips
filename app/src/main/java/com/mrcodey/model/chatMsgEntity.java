package com.mrcodey.model;

/*
 * 消息的实体类
 * 之后可以添加时间/聊天的人名等
 */
public class chatMsgEntity {
	private boolean msgType;// 发送类型，是哪一边发送的

	private String chatContent;// 聊天内容

	public boolean isMsgType() {
		return msgType;
	}

	public void setMsgType(boolean msgType) {
		this.msgType = msgType;
	}

	public String getChatContent() {
		return chatContent;
	}

	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}

	public chatMsgEntity(String content,boolean msgType) {
		super();
		this.chatContent=content;
		this.msgType=msgType;
	}
	

}
