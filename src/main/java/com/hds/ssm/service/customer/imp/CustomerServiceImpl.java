package com.hds.ssm.service.customer.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hds.ssm.dao.CustomerDao;
import com.hds.ssm.model.Customer;
import com.hds.ssm.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value="CustomerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Override
    public PageInfo<Customer> GetCustomer(int pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Customer> customers =customerDao.GetCustomer();
        PageInfo<Customer> pageInfo=new PageInfo<>(customers);
        return pageInfo;
    }

    @Override
    public PageInfo<Customer> GetCertCustomer(int pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Customer>customers=customerDao.GetCertCustomer();
        PageInfo<Customer> pageInfo=new PageInfo<>(customers);
        return pageInfo;
    }

    @Override
    public Integer GetTotal() {
        return customerDao.GetTotal();
    }

    @Override
    public Integer GetCertNum() {
        return customerDao.GetCertNum();
    }

    @Override
    public void addCustomer(int useId, String username, String phone, String sex, String idnumber) {
         customerDao.addCustomer(useId,username,phone,sex,idnumber);
    }

    @Override
    public Customer findCustomer(Integer userId) {
        return customerDao.findCustomer(userId);
    }

    @Override
    public void commitCert(String idNumber, Integer userId, String imgSrc, String projectId, String state,String plateNumber) {
        customerDao.commitCert(userId,imgSrc,projectId,state);
        customerDao.customerCertChange(userId,idNumber,projectId,plateNumber);

    }

    @Override
    public Map adjustCert(Integer userId) {
        return customerDao.adjustCert(userId);
    }

    @Override
    public void commitEvaluation(Integer userId, String projectId, Integer degress, String content) {
        customerDao.commitEvaluation(userId,projectId,degress,content);
    }

    @Override
    public void alterCustomer(Integer customerId, String phone, String plateNum, String idnumber, Integer sex) {
        customerDao.alterCustomer(customerId,phone,plateNum,idnumber,sex);
    }

    @Override
    public PageInfo<Customer> searchCustomerByName(int pageNum, String name) {
        PageHelper.startPage(pageNum,10);
        List<Customer> customers = this.customerDao.searchCustomerByName(name);
        PageInfo<Customer> pageInfo = new PageInfo<>(customers);
        return pageInfo;
    }


}
