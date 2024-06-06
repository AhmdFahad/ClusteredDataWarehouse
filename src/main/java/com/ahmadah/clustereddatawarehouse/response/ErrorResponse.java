package com.ahmadah.clustereddatawarehouse.response;

import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter@Getter
@ToString
public class ErrorResponse {
    private String error;
    private String massage;
    private String status;
    @Builder.Default
    private Date timestamp=new Date();
    private String path;
}
