package com.sbhima.auth.controller.commons;

public class AjaxResponse<T> {
	private T data;
	private boolean error = false;
	private String errorMessage = "";

	public AjaxResponse(T data) {
		this.data = data;
	}

	public AjaxResponse() {

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
