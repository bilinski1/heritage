package com.heritage.dto;
import com.heritage.entity.UserEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserProjectDto {

        private Long id;
        private String name;
        private String description;
        private UserEntity user;



}
