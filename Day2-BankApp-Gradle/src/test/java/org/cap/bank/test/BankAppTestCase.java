package org.cap.bank.test;

import static org.junit.Assert.*;

import org.cap.dao.AccountDao;
import org.cap.dto.Account;
import org.cap.dto.Customer;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BankAppTestCase {

	@Mock
	private AccountDao accountDao;
	private AcccountService acccountService;
	
	@Before
	public void beforeTestCase(){
		MockitoAnnotations.initMocks(this);
		
		acccountService=new AccountServiceImpl(accountDao);
	}
	
	
	@Test
	public void find_by_account_number_testcase(){
		
		Account account=new Account();
		account.setAccountNo(12);
		Customer customer=new Customer();
		account.setCustomer(customer);
		account.setAmount(1000);
		
		
		
		//Mock Objects
		//Declarations
		Mockito.when(accountDao.findAccountById(12)).thenReturn(account);
		
		//INvoke Mock Object
		Account newAcc=acccountService.findAccountById(12);
		
		//Verification of Mock Object
		Mockito.verify(accountDao).findAccountById(12);
		
		
		//assertEquals(newAcc.getAccountNo(),account.getAccountNo());
		
	}
	
	//@Test(expected=IllegalArgumentException.class)
	
	
	

}
