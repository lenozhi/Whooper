/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.whooper.repository;

import cn.whooper.domain.AlarmObject;
import cn.whooper.domain.UserFans;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 读取提醒基础信息的初始化接口
 *
 * @author joephoenix
 */
public interface AlarmRepository extends CrudRepository<AlarmObject, Integer>,
PagingAndSortingRepository<AlarmObject, Integer>   {

    /**
     * 按照用户查询用户自己的提醒
     *
     * @param AUTHOR 用户id
     * @return
     */
    public List<AlarmObject> findByAuthor(String author);

    /**
     * 按照提醒的标题查询
     *
     * @param TITLE 提醒的标题
     * @return
     */
    public AlarmObject findByTitle(String title);

    /**
     * 查询创建时间在时间区间内的提醒
     *
     * @param before 过去时间范围
     * @param after 未来时间范围
     * @return
     */
    @Query("select a from AlarmObject a where a.createtime between ?1 and ?2")
    public AlarmObject selectByCreatetimeZone(Date before, Date after);
    
    @Query("select a from AlarmObject a ")
    public Page<AlarmObject> findBySome(Pageable p);
}
