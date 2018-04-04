package com.telecom.project.powermag.operationservice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.beans.PowerBean;
import com.telecom.project.powermag.operationdao.IOperationPowerDao;
import com.telecom.project.powermag.operationservice.IOperationPowerService;

@Service
public class OperationPowerServiceImpl implements IOperationPowerService {
	
	@Resource
	private IOperationPowerDao  operationPowerDao;
	@Override
	public void savePower(PowerBean power) {
		// TODO Auto-generated method stub
		operationPowerDao.save(power);
	}

	@Override
	public void deletePower(PowerBean power) {
		// TODO Auto-generated method stub
		
		operationPowerDao.delete(power);
	}

	@Override
	public void updatePower(PowerBean power) {
		// TODO Auto-generated method stub
		operationPowerDao.saveAndFlush(power);
	}

	@Override
	public void deleteBatchPower(List<PowerBean> powers) {
		// TODO Auto-generated method stub
		operationPowerDao.deleteInBatch(powers);
	}

	@Override
	public void livePower(PowerBean power) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void TimeOutPowerBeanById(PowerBean power) {
		// TODO Auto-generated method stub
		
	}
		
	
}
