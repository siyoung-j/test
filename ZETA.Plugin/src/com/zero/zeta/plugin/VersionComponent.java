package com.zero.zeta.plugin;

import com.zero.zeta.common.message.Field;
import com.zero.zeta.common.message.Message;
import com.zero.zeta.common.message.exception.MessageException;
import com.zero.zeta.exception.business.BusinessException;
import com.zero.zeta.plugin.component.AbstractBusinessClass;
import com.zero.zeta.plugin.connector.AcceptedObject;

public class VersionComponent extends AbstractBusinessClass {

	// "response" id의 value를 넣는 작업

	@Override
	public void execute(AcceptedObject obj) throws BusinessException {

		Message inputMessage = obj.getInputMessage();
		Message outputMessage = obj.getOutputMessage();

		try {

			String idValue = "";

			/* get id from InputMessage */ {

				// 들어온 msg의 id value값 받아오기
				Field id = (Field)inputMessage.getChild("id");
				idValue = id.getDataString();
			}

			/* set id from OutputMessage */ {

				Field id = (Field)outputMessage.getChild("id");
				// data set > id
				id.setData(idValue.getBytes());
				
				Field result = (Field) outputMessage.getChild("result");
				// data set > result
				String data = this.getParameter("data");
				result.setData(data.getBytes());
			}

			/*
			 * 테스트 시,
			 * <?xml version="1.0" encoding="UTF-8"?>
			 * <request>
			 * 	<id>MI</id>
			 * </request>
			 * 
			 * 형식으로 해야한다.
			 */
			
		} catch (MessageException e) {
			logDebug("Message Error", e);
		}
		// obj.setExecuted(true); //오류나면 SYNC action이 돌지않고 false된다.
	}
}
