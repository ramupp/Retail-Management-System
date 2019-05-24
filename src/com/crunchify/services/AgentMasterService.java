package com.crunchify.services;
import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.AgentMasterBean;
import com.crunchify.model.ItemTypeBean;

public interface AgentMasterService {

	public String agentMasterCreate(AgentMasterBean agent) throws SpringCrunchifyException;

	List<AgentMasterBean> agent() throws SpringCrunchifyException;

	String agentMasterUpdate(AgentMasterBean agent)throws SpringCrunchifyException;

	String agentTypeDelete(AgentMasterBean agent_typ)throws SpringCrunchifyException;

}
