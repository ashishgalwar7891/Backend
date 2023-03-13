package com.example.spring5Demo1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data //getters and setters
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book
{
    String b_id, b_name, author, isbn_no;
    int price,stock;
}
