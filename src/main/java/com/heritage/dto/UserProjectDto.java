package com.heritage.dto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.heritage.entity.UserEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class UserProjectDto {

        private Long id;
        private String name;
        private String description;
        private Long userId;



}
