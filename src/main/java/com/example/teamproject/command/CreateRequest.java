package com.example.teamproject.command;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateRequest {
	private long amount;
	private String name;
	private String address;
	private List<File> files;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class File {
		private int productId;
		private long Price;
		private String description;
	}
}
