package com.blb.comment.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value ="t_user")
public class TUser {

  @TableId(value = "id", type = IdType.AUTO)
  private Long id;
  private String username;
  private String password;
  private String phone;




}
