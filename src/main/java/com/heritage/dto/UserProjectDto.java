package com.heritage.dto;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserProjectDto {

        private Long id;
        private String name;
        private String description;


}
