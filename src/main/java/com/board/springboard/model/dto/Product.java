package com.board.springboard.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString @AllArgsConstructor @NoArgsConstructor
public class Product {
    private Long id; //integer 보다 숫자범위가 더 넒음, 대기업 long 사용한다
    private String name;
    private int price;
    private int stock;
    private LocalDateTime created_at;





    }
