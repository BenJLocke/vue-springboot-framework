package cn.benlocke.webservice.web.entity;

import lombok.Data;

@Data
public class JsonResponse {
	private String msg;
	private boolean status;
	private Object data;

	public JsonResponse(String msg, boolean status) {
		this.msg = msg;
		this.status = status;
	}

	public JsonResponse(String msg, boolean status, Object data) {
		this.msg = msg;
		this.status = status;
		this.data = data;
	}
}
