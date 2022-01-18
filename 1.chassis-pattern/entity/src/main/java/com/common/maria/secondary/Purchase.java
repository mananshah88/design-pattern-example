package com.common.maria.secondary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchase")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer customerId;
	private Integer itemId;
	private Integer quantity;
	private Double amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Purchase() {

	}

	public Purchase(Long id, Integer customerId, Integer itemId, Integer quantity, Double amount) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", customerId=" + customerId + ", itemId=" + itemId + ", quantity=" + quantity
				+ ", amount=" + amount + "]";
	}

}
