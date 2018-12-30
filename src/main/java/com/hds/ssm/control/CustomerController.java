package com.hds.ssm.control;

import com.github.pagehelper.PageInfo;
import com.hds.ssm.model.Customer;
import com.hds.ssm.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api")
@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @ResponseBody
    @RequestMapping(value = "/getcustomer",method = RequestMethod.GET)
    public PageInfo<Customer> GetCustomer(@RequestParam("pageNum") int pageNum)
    {
        return    customerService.GetCustomer(pageNum);
    }
    @ResponseBody
    @RequestMapping(value = "/getcertcustomer",method = RequestMethod.GET)
    public PageInfo<Customer>GetCertCustomer(@RequestParam("pageNum") int pageNum)
    {
        return customerService.GetCertCustomer(pageNum);
    }

    @ResponseBody
    @RequestMapping(value = "/gettotal",method = RequestMethod.GET)
    public Integer GetTotal()
    {
        return customerService.GetTotal();
    }
    @ResponseBody
    @RequestMapping(value = "/getcertnum",method = RequestMethod.GET)
    public Integer GetCertNum()
    {
        return customerService.GetCertNum();
    }
}
