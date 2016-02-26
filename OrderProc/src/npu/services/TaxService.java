package npu.services;

import npu.domain.Order;

public interface TaxService {
	public double computeTax(Order order);
}
