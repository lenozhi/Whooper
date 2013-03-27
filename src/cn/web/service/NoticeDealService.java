/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.web.service;

import cn.web.dao.NoticeLinkStatusDao;
import cn.web.dao.NoticecontextDao;
import cn.web.domain.Noticecontext;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author joephoenix
 */
@Service("noticeDealService")
@Transactional
public class NoticeDealService {

    //日志
    protected static Logger logger = Logger.getLogger("service");
    //依赖注入
    @Resource(name = "noticecontextDao")
    private NoticecontextDao noticecontextDao;
    @Resource(name = "noticeLinkStatusDao")
    private NoticeLinkStatusDao noticeLinkStatusDao;

    /**
     * ******处理方法*********
     */
    /**
     * 查找每个用户的提醒和通知
     *
     * @return
     */
    public List<Noticecontext> findUserNotice(String email) {
        return noticecontextDao.findNoticesByUser(email);
    }

    /**
     * 生成一条新的提醒
     *
     * @param notice
     */
    public void insertNotice(Noticecontext notice) {
        noticecontextDao.insertNotice(notice);
    }

    /**
     * 修改一条提醒
     *
     * @param notice
     */
    public void updateNotice(Noticecontext notice) {
        noticecontextDao.updateById(notice);
    }
}
