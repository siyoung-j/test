package com.zero.zeta.plugin;

import com.zero.zeta.exception.business.BusinessException;
import com.zero.zeta.plugin.component.AbstractBusinessClass;
import com.zero.zeta.plugin.connector.AcceptedObject;

public class AcceptComponent extends AbstractBusinessClass {

	@Override
	public void execute(AcceptedObject arg0) throws BusinessException {

		//<parameter name="AcceptComponent.data" value="HELLO ZETA" /> 에서 value값 > data
		String data = this.getParameter("data");
		
		logDebug("on Accept {" + data + "} {" + this.getClass().getName() + "}");
		
	}

}
