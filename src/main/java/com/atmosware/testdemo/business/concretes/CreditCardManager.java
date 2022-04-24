package com.atmosware.testdemo.business.concretes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.atmosware.testdemo.business.abstracts.CreditCardService;
import com.atmosware.testdemo.business.common.exceptions.BusinessException;
import com.atmosware.testdemo.business.requests.CreateCreditCardRequest;
import com.atmosware.testdemo.dataAccess.abstracts.EntityDao;
import com.atmosware.testdemo.dataAccess.concretes.InMemoryDao;
import com.atmosware.testdemo.entities.concretes.CreditCard;

@Service
public class CreditCardManager implements CreditCardService {
	
	private EntityDao entityDao;
	
	public CreditCardManager(EntityDao entityDao) {
		
		this.entityDao = entityDao;
		
	}
	
	public void add(CreateCreditCardRequest createCreditCardRequest) throws ParseException {
		
		checkCreditCardExpired(createCreditCardRequest);
		
		CreditCard creditCard = new CreditCard(entityDao.creditCars.size()+1,
												createCreditCardRequest.getCardHolder(),
													createCreditCardRequest.getCardNumber(),
														createCreditCardRequest.getCsv(),
															createCreditCardRequest.getExpiration());
		
		entityDao.creditCars.add(creditCard);
		
	}
	
	@Override
	public void getAll() {
		
		System.out.println("\n"+entityDao.creditCars+"\n");
		
	}
	
	
	@Override
	public void checkCreditCardExpired(CreateCreditCardRequest createCreditCardRequest) throws ParseException {
		
		String expireDate = "30/"+createCreditCardRequest.getExpiration().substring(0, 2)+"/20"+createCreditCardRequest.getExpiration().substring(3,5);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
		Date expirationDate = simpleDateFormat.parse(expireDate);
		
		if(expirationDate.before(new Date(System.currentTimeMillis()))){
			
			throw new BusinessException("CreditCard.Expired");
			
		}
		
		
		
	}
	
}
