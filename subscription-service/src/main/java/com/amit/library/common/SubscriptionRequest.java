package com.amit.library.common;

import com.amit.library.entity.SubscriptionEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionRequest {
	
	private SubscriptionEntity subentity;
	//private Book book;

}
