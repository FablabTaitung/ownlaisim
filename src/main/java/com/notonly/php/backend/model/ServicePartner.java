package com.notonly.php.backend.model;

import javax.persistence.Embeddable;

@Embeddable
public class ServicePartner {

    String serviceId = "";
	String proxy = "";
	String target = "";
	String preService = "";
	String postService = "";
	
	public String getServiceId() {
		return serviceId;
	}
	
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	
	public String getProxy() {
		return proxy;
	}
	
	public void setProxy(String proxy) {
		this.proxy = proxy;
	}
	
	public String getTarget() {
		return target;
	}
	
	public void setTarget(String target) {
		this.target = target;
	}
	
	public String getPreService() {
		return preService;
	}
	
	public void setPreService(String preService) {
		this.preService = preService;
	}
	
	public String getPostService() {
		return postService;
	}
	
	public void setPostService(String postService) {
		this.postService = postService;
	}
}
