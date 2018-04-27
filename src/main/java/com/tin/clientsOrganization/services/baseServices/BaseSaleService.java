package com.tin.clientsOrganization.services.baseServices;

import com.tin.clientsOrganization.entities.Customer;
import com.tin.clientsOrganization.entities.Quota;
import com.tin.clientsOrganization.entities.Sale;
import com.tin.clientsOrganization.repositories.QuotaRepository;
import com.tin.clientsOrganization.repositories.SaleRepository;
import com.tin.clientsOrganization.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BaseSaleService implements SaleService {

    @Autowired
    private SaleRepository saleRepository;
    
    @Autowired
    private QuotaRepository quotaRepository;

    @Override
    public Sale findById(Long id) {
        return saleRepository.findById(id);
    }

    @Override
    public Sale save(Sale sale) {
        sale.setQuotas(generateCuotas(sale));
        return saleRepository.save(sale);
    }

    @Transactional
    protected Sale saveSale(Sale sale){
    	return saleRepository.save(sale);
    }

    private  List<Quota> generateCuotas(Sale sale) {
    	Date beginningDate = (Date) sale.getDate().clone();
    	
    	Integer fees = sale.getFees();
    	List<Quota> quotasToReturn = new ArrayList();
    	for (int i = 1 ; i <= fees ; i++) {
    		Quota quota = new Quota();
    		Calendar calendar = Calendar.getInstance();
    		calendar.setTime(beginningDate);
    		calendar.add(Calendar.MONTH, i);
    		quota.setDate(calendar.getTime());
    		quota.setAmount(sale.getAmount()/fees);
    		quotasToReturn.add(quota);
    		quota.setSale(sale);
    	}
    	return quotasToReturn ;
	}

	@Override
    public Sale delete(Sale sale) {
        try {
            saleRepository.delete(sale);
            return sale;
        } catch (Exception e){
            throw new RuntimeException("sale not found.");
        }
    }

    @Override
    public Sale update(Sale sale) {
        Sale saleToUpdate = saleRepository.findById(sale.getId());
        saleToUpdate.setAmount(sale.getAmount()!=null?sale.getAmount():saleToUpdate.getAmount());
        saleToUpdate.setProduct(sale.getProduct()!=null?sale.getProduct():saleToUpdate.getProduct());
        saleToUpdate.setCustomer(sale.getCustomer()!=null?sale.getCustomer():saleToUpdate.getCustomer());
        saleToUpdate.setDate(sale.getDate()!=null?sale.getDate():saleToUpdate.getDate());
        saleToUpdate.setFees(sale.getFees()!=null?sale.getFees():saleToUpdate.getFees());
        saleRepository.updateById(sale.getId(),sale.getAmount(),sale.getCustomer(),sale.getDate(),
                sale.getFees(),sale.getProduct());
        return saleToUpdate;
    }

    @Override
    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    @Override
    public List<Sale> findByCustomer(Long id) {
        Customer customer = new Customer();
        customer.setId(id);
        return saleRepository.findByCustomer(customer);
    }
}
