package cn.ylw.activiti.entity;

import lombok.Data;

/**
 * 用户
 *
 * @author yanluwei
 * @date 2020/9/17
 */
@Data
public class User {
    private Integer id;
    private String role;
    private String name;
}
