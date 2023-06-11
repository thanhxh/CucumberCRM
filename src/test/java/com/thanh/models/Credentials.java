package com.thanh.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                       //là dùng để tự động hiểu các hàm Get và Set
@NoArgsConstructor          //dùng để tự động khởi tạo hàm xây dựng không có tham số
@AllArgsConstructor         //dùng để tự động khởi tạo hàm xây dựng có đủ các tham số
public class Credentials {
    private String username;
    private String password;
}