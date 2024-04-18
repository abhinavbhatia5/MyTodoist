package com.example.MyTodoist.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="MyDataSource")
public class ListItem {

    @Id
    @GeneratedValue
    private Long Id;

    @NotBlank(message = "Name is mandatory")
    @Column(unique = true)
    private String Title;
    @NonNull
    private boolean IsDone;

    public ListItem(Long Id,String title,boolean isDone){
        this.Id=Id;
        this.Title=title;
        this.IsDone=false;
    }

}
