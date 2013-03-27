/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.whooper.repository;

import cn.whooper.domain.UserWatch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author joephoenix
 */
@Repository("userWatchRepository")
public interface UserWatchRepository extends CrudRepository<UserWatch, Integer>,
        PagingAndSortingRepository<UserWatch, Integer> {

    public UserWatch findByUseremail(String useremail);
}
