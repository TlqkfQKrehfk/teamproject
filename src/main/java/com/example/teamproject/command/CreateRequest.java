package com.example.teamproject.command;

import java.io.File;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CreateRequest {
	private long amount;
	private String name;
	private String address;
	private List<File> files;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Detail {
		private int productId;
		private long unitPrice;
		private int quantity;
	}
}
