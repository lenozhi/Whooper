/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.whooper.repository;

import cn.whooper.domain.UserWatch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 读取用户关注对象的持久化对象接口
 *
 * @author joephoenix
 */
public interface UserWatchRepository extends CrudRepository<UserWatch, Integer>,
        PagingAndSortingRepository<UserWatch, Integer> {

    public UserWatch findByUseremail(String useremail);
}
