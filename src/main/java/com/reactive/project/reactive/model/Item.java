package com.reactive.project.reactive.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Table("Item")
@Data
@AllArgsConstructor
public class Item {

	@Id
	private int id;

	private String descricao;

}
