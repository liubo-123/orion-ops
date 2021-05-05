package com.orion.ops.entity.request;

import com.orion.lang.wrapper.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户请求
 *
 * @author Jiahang Li
 * @version 1.0.0
 * @since 2021/4/25 18:58
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserInfoRequest extends PageRequest {

    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色类型 10超级管理员 20管理员 30开发 40运维
     *
     * @see com.orion.ops.consts.RoleType
     */
    private Integer roleType;

    /**
     * 用户状态 1启用 2禁用
     */
    private Integer userStatus;

    /**
     * 联系手机
     */
    private String contactPhone;

    /**
     * 联系邮箱
     */
    private String contactEmail;

    /**
     * 头像base64
     */
    private String headPic;

}
