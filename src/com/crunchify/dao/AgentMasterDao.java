package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.AgentMasterBean;

public interface AgentMasterDao {
	public String agentMasterCreate(AgentMasterBean agent) throws SpringCrunchifyException;

	

	String viewAgentCreate(AgentMasterBean agent)
			throws SpringCrunchifyException;

	String agentMasterUpdate(AgentMasterBean agent)
			throws SpringCrunchifyException;



	List<AgentMasterBean> agent() throws SpringCrunchifyException;

		String agentTypeDelete(AgentMasterBean agent_typ)throws SpringCrunchifyException;

}
