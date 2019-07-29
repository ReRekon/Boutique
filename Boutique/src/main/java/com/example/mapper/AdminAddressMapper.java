package com.example.mapper;

import com.example.entity.AdminAddress;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AdminAddressMapper {
    /**
     * 增加地址
     * @param adminAddress
     * @return
     * 方法名第一个小写，第二个大写
     */
    int add(AdminAddress adminAddress);
    /**
     * 删除地址
     * @param aid
     * @return
     */
    int delete(int aid);
    /**
     *修改地址
     * @param adminAddress
     * @return
     */
    int update(AdminAddress adminAddress);
    /**
     * 查询地址
     * @param uname
     * @return
     */
    List<AdminAddress> findAll(String uname);
    //AdminAddress findone(Integer aid); //测试查询一条数据
}
