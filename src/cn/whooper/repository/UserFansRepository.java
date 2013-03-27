/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.whooper.repository;

import cn.whooper.domain.UserFans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author joephoenix
 */
@Repository("userFansRepository")
public interface UserFansRepository extends CrudRepository<UserFans, Integer>,
        PagingAndSortingRepository<UserFans, Integer> {

    public UserFans findByUseremail(String useremail);
}
