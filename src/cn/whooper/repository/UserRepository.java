/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.whooper.repository;

import cn.whooper.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 用户表的持久化处理方法
 *
 * @author joephoenix
 */
public interface UserRepository extends CrudRepository<User, Integer>,
        PagingAndSortingRepository<User, Integer> {

    public User findByEmail(String email);
}
