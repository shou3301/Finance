package org.cs.demoria.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.cs.demoria.dao.AccountDao;
import org.cs.demoria.dao.InvestDao;
import org.cs.demoria.dao.ProductDao;
import org.cs.demoria.model.Investment;
import org.cs.demoria.model.Product;
import org.cs.demoria.service.InvestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("investService")
public class InvestServiceImpl implements InvestService {

	private AccountDao accountDao;
	private ProductDao productDao;
	private InvestDao investDao;
	
	@Override
	@Transactional
	public void makeInvestment(Integer pid, Integer aid) {
		Product product = productDao.findProductById(pid);
		Investment investment = new Investment();
		investment.setInitUnitPrice(10.0);
		investment.setUnit(20.0);
		investment.setTransactionDate(new Date());
		investment.setProduct(product);
		
		investDao.saveInvest(investment);
		accountDao.insertInvestmentById(aid, investment);
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	@Resource(name="accountDao")
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	@Resource(name="productDao")
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public InvestDao getInvestDao() {
		return investDao;
	}

	@Resource(name="investDao")
	public void setInvestDao(InvestDao investDao) {
		this.investDao = investDao;
	}

}
