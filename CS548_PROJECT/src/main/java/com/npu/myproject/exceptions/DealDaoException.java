package com.npu.myproject.exceptions;

public class DealDaoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
   public DealDaoException(String msg){
	   super(msg);
   }
}
