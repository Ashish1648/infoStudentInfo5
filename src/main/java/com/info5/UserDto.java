package com.info5;

import com.info5.Dto.AddressDto;
import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String userName;
    private AddressDto address;
}
