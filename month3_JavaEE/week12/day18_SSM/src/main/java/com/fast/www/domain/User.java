package com.fast.www.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * 实体类
 *
 * @author minjie
 * @since 2023/05/17 17:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;    // username
    private String password;   // password
    private String imageurl; // 头像文件url
}


