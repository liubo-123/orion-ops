package com.orion.ops.consts.event;

import com.alibaba.fastjson.JSON;
import com.orion.lang.collect.MutableMap;
import com.orion.ops.entity.domain.UserEventLogDO;
import com.orion.ops.utils.EventLogUtils;
import com.orion.utils.Strings;
import lombok.Getter;

import java.util.Date;

/**
 * 事件类型
 *
 * @author Jiahang Li
 * @version 1.0.0
 * @since 2021/4/20 21:25
 */
@Getter
public enum EventType {

    /**
     * 登陆
     */
    LOGIN(10, "登陆系统"),

    /**
     * 登出
     */
    LOGOUT(20, "退出系统"),

    /**
     * 登出
     */
    RESET_PASSWORD(30, "重置用户 ${target_username} 密码"),

    ;

    EventType(Integer type, String template) {
        this.type = type;
        this.template = template;
    }

    /**
     * 类型
     */
    private final Integer type;

    /**
     * 模板
     */
    private final String template;

    /**
     * 获取操作日志对象
     *
     * @return event
     */
    public UserEventLogDO getEventLog() {
        MutableMap<String, Object> map = EventParamsHolder.get();
        EventParamsHolder.remove();
        // 判断是否保存
        if (!map.getBooleanValue(EventKeys.INNER_SAVE, true)) {
            return null;
        }
        // 读取内置参数
        Long userId = map.getLong(EventKeys.INNER_USER_ID);
        if (userId == null) {
            return null;
        }
        // 设置对象
        UserEventLogDO log = new UserEventLogDO();
        log.setUserId(userId);
        log.setUsername(map.getString(EventKeys.INNER_USER_NAME));
        log.setEventType(type);
        log.setLogInfo(Strings.format(map.getString(EventKeys.INNER_TEMPLATE, template), map));
        // 移除内部key
        EventLogUtils.removeInnerKeys(map);
        log.setParamsJson(JSON.toJSONString(map));
        log.setCreateTime(new Date());
        return log;
    }

}