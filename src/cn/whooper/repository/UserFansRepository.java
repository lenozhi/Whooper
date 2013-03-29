/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.whooper.repository;

import cn.whooper.domain.UserFans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 读取用户粉丝的接口
 *
 * @author joephoenix
 */
public interface UserFansRepository extends CrudRepository<UserFans, Integer>,
        PagingAndSortingRepository<UserFans, Integer> {

    public UserFans findByUseremail(String useremail);
}
