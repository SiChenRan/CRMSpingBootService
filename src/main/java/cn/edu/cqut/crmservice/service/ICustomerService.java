package cn.edu.cqut.crmservice.service;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.Report;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.swing.*;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author baomidou
 * @since 2023-06-06
 */
public interface ICustomerService extends IService<Customer> {

    List<Report> getCustomerCountByRegion();

    List<Report> getAmountByReCusID();

    String getCusNameByID(int id);


 }
