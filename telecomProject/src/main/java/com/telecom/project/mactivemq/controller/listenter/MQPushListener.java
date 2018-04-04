package com.telecom.project.mactivemq.controller.listenter;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component("MQPushListener")
public class MQPushListener implements MessageListener {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private BillDay billDay;
	@Resource
	private BillMonth billMonth;
	@Resource
	private BillYear billYear;

	@Override
	public void onMessage(Message message) {

		TextMessage textMessage = (TextMessage) message;
		try {
			String jsonStr = textMessage.getText();
			if (jsonStr != null) {
				String map = JSON.parseObject(jsonStr, String.class);
				System.out.println("==============================漂亮的分割线上====================================");
				switch (map) {
				case "每日定期任务":
					billDay.execute();
					break;
				case "每月定期任务":
					billMonth.execute();
					break;
				case "每年定期任务":
					billYear.execute();
					break;
				}
				System.out.println("==============================漂亮的分割线下====================================");
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.error("监听器GG啦~~",e);
		}

	}

}
