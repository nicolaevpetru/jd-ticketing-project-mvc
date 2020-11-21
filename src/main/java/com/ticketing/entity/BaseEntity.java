package com.ticketing.entity;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class BaseEntity {
    private Long id;
    private LocalDateTime insertDataTime;
    private Long insertUserId;
    private LocalDateTime lastUpdateDataTime;
    private Long lastUpdateUserId;
}
