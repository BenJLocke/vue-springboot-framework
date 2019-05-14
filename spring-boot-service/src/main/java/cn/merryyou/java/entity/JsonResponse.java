package cn.merryyou.java.entity;

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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
