package com.telecom.project.powermag.operationpowerservice;

import java.util.List;

import com.telecom.project.beans.PowerBean;

public interface IOperationPowerService {
	/**
	 * 保存权限
	 * @param pawer
	 */
	public void savePower(PowerBean pawer);
	
	/**
	 * 删除权限
	 * @param power
	 */
	public void deletePower(PowerBean power);
	
	/**
	 * 修改权限
	 * @param power
	 */
	public void updatePower(PowerBean power);
	
	/**
	 * 批量删除权限
	 * @param powers
	 */
	public void deleteBatchPower(List<PowerBean> powers);
}
