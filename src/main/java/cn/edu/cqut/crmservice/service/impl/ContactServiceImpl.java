package cn.edu.cqut.crmservice.service.impl;

import cn.edu.cqut.crmservice.entity.Contact;
import cn.edu.cqut.crmservice.mapper.ContactMapper;
import cn.edu.cqut.crmservice.service.IContactService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CQUT
 * @since 2023-06-08
 */
@Service
public class ContactServiceImpl extends ServiceImpl<ContactMapper, Contact> implements IContactService {

}
