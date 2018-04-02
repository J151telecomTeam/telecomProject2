package com.telecom.project.dealmag.operationservice;

import java.util.List;

import com.telecom.project.beans.DealBean;

public interface IOperationDealService {
	
	/**
	 * 新增资费
	 * @param deal
	 */
	public void saveDealBean(DealBean deal);
	
	/**
	 * 修改资费
	 * @param deal
	 */
	public void updateDealBean(DealBean deal);
	
	/**
	 * 批量删除
	 */
	public void deleteBatchDealBean(List<DealBean> deals);
	
}
