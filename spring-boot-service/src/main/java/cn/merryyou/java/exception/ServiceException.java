package cn.merryyou.java.exception;

public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 4708642347970764653L;

	public ServiceException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return this.getMessage();
	}
}
