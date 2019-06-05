package com.zero.zeta.plugin;

import com.zero.zeta.common.message.Field;
import com.zero.zeta.common.message.Message;
import com.zero.zeta.common.message.exception.MessageException;
import com.zero.zeta.exception.business.BusinessException;
import com.zero.zeta.plugin.component.AbstractBusinessClass;
import com.zero.zeta.plugin.connector.AcceptedObject;

public class EduComponent extends AbstractBusinessClass {

	@Override
	public void execute(AcceptedObject obj) throws BusinessException {
		
		Message inputMsg = obj.getInputMessage();
		Message outputMsg = obj.getOutputMessage();
		
		try {
			
			String num1 = "";
			String num2 = "";
			
			/* get Message */ {
				
				Field f1 = (Field) inputMsg.getChild("num1");
				num1 = f1.getDataString();
				
				Field f2 = (Field) inputMsg.getChild("num2");
				num2 = f2.getDataString();
				
				/*
				System.out.println("---------++++++++++++---------");
				System.out.println("num1 : " + num1 + ", num2 : " + num2);
				System.out.println("---------++++++++++++---------");
				*/
			}
			
			/* set Message */ {
				
				Field f1 = (Field) outputMsg.getChild("num1");
				f1.setData(num1.getBytes());
				
				Field f2 = (Field) outputMsg.getChild("num2");
				f2.setData(num2.getBytes());
				
				String sum = (Integer.parseInt(num1) + Integer.parseInt(num2)) + "";
				
				Field f3 = (Field) outputMsg.getChild("sum");
				f3.setData(sum.getBytes());
			}
			
			
		} catch (MessageException e) {
			logDebug("Message Error", e);
		}
	}

}
