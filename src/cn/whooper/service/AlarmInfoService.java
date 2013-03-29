/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.whooper.service;

import cn.whooper.domain.AlarmObject;
import cn.whooper.repository.AlarmRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 对提醒进行处理的服务，如提醒内容的读取，提醒发送状态的读取
 *
 * @author joephoenix
 */
@Service("alarmInfoService")
public class AlarmInfoService {

    @Autowired
    private AlarmRepository alarmRepository;

    public List<AlarmObject> findInfoByAuthor(String AuthorId) {
        return alarmRepository.findByAUTHOR(AuthorId);
    }
}
