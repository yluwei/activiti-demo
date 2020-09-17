package cn.ylw.activiti.entity;

import lombok.Data;

/**
 * 假期
 *
 * @author yanluwei
 * @date 2020/9/17
 */
@Data
public class Vacation {
    private Integer id;
    private String type;
    private String procdefId;
}
