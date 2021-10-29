package com.wei.swagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("用户实体类")    //注释作用
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("用户名")
    private String password;
}