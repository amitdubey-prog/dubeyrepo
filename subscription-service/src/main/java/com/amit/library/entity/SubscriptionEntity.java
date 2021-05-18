package com.amit.library.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="SUBSCRIPTION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionEntity
{
	
	@Id
	@GeneratedValue
	private int  Subscriptionid;
	 private String subscriberName;
		private LocalDate dateSubscribed;
		private LocalDate dateReturned;
		private int  bookId;
		

}
