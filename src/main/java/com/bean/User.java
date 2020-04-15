package com.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends Person {

    private Integer id;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;


    public static void main(String[] args) throws Exception {

        User user = new User();
        user.setId(1);
        user.setLastLoginTime(new Date());

        ObjectMapper mapper = new ObjectMapper();

        String  text = mapper.writeValueAsString(user);
        System.out.println(text);

        String text2 = "{\"id\":1,\"lastLoginTime\":\"2020-04-15 09:57:01\"}";
        User p2 = mapper.readValue(text2, User.class);
        System.out.println(p2);

    }
}
