package com.notonly.php.backend.model;

import javax.persistence.Embeddable;

@Embeddable
public class AmazingService {

	String serviceId = "";
	String serviceName = "";
	
	//phase -> result
	protected String phase = "";
	protected String resultPhase = "";
	
	//Feature
	protected boolean boot = false;
	protected boolean repeatable = false;
	protected boolean singleton = false;
	protected boolean immediate = false;

	protected boolean provided = false;
	
	//Role
	protected boolean receiver = false;
	protected boolean requester = false;
	protected boolean service = false;
	
	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getResultPhase() {
		return resultPhase;
	}

	public void setResultPhase(String resultPhase) {
		this.resultPhase = resultPhase;
	}

	public boolean isBoot() {
		return boot;
	}

	public void setBoot(boolean boot) {
		this.boot = boot;
	}

	public boolean isRepeatable() {
		return repeatable;
	}

	public void setRepeatable(boolean repeatable) {
		this.repeatable = repeatable;
	}

	public boolean isSingleton() {
		return singleton;
	}

	public void setSingleton(boolean singleton) {
		this.singleton = singleton;
	}

	public boolean isImmediate() {
		return immediate;
	}

	public void setImmediate(boolean immediate) {
		this.immediate = immediate;
	}

	public boolean isProvided() {
		return provided;
	}

	public void setProvided(boolean provided) {
		this.provided = provided;
	}

	public boolean isReceiver() {
		return receiver;
	}

	public void setReceiver(boolean receiver) {
		this.receiver = receiver;
	}

	public boolean isRequester() {
		return requester;
	}

	public void setRequester(boolean requester) {
		this.requester = requester;
	}

	public boolean isService() {
		return service;
	}

	public void setService(boolean service) {
		this.service = service;
	}
	
}
