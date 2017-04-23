package com.zx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSell {
    private Integer usid;

    private String usname;

    private String ustruename;

    private String uspassword;

    private String usphone;

    private String usidcard;

    private String usaddress;

    private Integer usdel;

}