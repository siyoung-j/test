package com.zero.zeta.plugin;

import com.zero.zeta.common.data.Record;
import com.zero.zeta.common.message.Field;
import com.zero.zeta.common.message.Message;
import com.zero.zeta.common.message.exception.MessageException;
import com.zero.zeta.exception.business.BusinessException;
import com.zero.zeta.plugin.component.AbstractBusinessClass;
import com.zero.zeta.plugin.connector.AcceptedObject;

public class TestComponent extends AbstractBusinessClass{

	@Override
	public void execute(AcceptedObject obj) throws BusinessException {
		//AcceptedObject > connector에서 가져온 data를 object로 가지고 있음
		
		Message inputMessage = obj.getInputMessage();
		
		logDebug("My First Component");
		
		try {
			
			//받은 메시지를 JSON 형태로 바꾸기
			//MessageBuilder jsonBuilder = MessageBuilderFactory.getInstance().getMessageBuilder("JSON");
			
			//logDebug("[JSON] [" + new String(jsonBuilder.convert(inputMessage))+"]");
			
			
			//한 필드의 내용 바꾸기
			Message record = (Message)inputMessage.getChild("record"); {
			
				for (int i = 0; i < record.rowCount(); i++) {
					Record r = record.getRow(i);
					
					//<contents>의 내용 바꾸기
					Field contents = (Field)r.get("contents"); {
						//내용을 "TEST_CONTENTS"로 변경
						contents.setData("TEST_CONTENTS".getBytes());
					}
					
					logDebug("Contents="+r.get("Contents"));
				}
			}
			
			logDebug(inputMessage.outline(0));
			
			//다른 Queue에 넣기 (OutputMessage의 Queue는 nonParsingMessage.xml에서 변경할 수 있다.)
			obj.setOutputMessage(inputMessage);
			
		} catch ( MessageException e) {
			
			logDebug("Parsing Error", e);
		}
		//obj.setExecuted(true);
	}

}
