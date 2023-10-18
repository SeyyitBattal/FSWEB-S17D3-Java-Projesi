package com.workintech.zoo.exceptions.kangrooException;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KangrooErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
