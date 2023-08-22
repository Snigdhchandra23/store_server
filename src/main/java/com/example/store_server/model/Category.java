package com.example.store_server.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="category")
@Entity

public class Category implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

        private String name;

        public void setId(Integer id) {
                this.id = Math.toIntExact(id);
        }

        public void setName(String name) {
                this.name = name;
        }
}
