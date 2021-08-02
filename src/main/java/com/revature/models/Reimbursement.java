package com.revature.models;

public class Reimbursement {

	private int reimb_id; // increments
	private int reimb_amount;
	private String submitted;
	private String resolved;
	private int author;
	private int resolver;
	private String description;
	private String type;
	private int typeId;
	private String status;
	private int statusId;
	private String authorName;
	private String resolverName;

	public Reimbursement(int reimb_id, int reimb_amount, String submitted, String resolved, String description,
			String type, int typeId, String status, int statusId) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.type = type;
		this.typeId = typeId;
		this.status = status;
		this.statusId = statusId;
	}

	public Reimbursement() {
		super();
	}

	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public int getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(int reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getResolver() {
		return resolver;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getResolverName() {
		return resolverName;
	}

	public void setResolverName(String resolverName) {
		this.resolverName = resolverName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + reimb_amount;
		result = prime * result + reimb_id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + statusId;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + typeId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (reimb_amount != other.reimb_amount)
			return false;
		if (reimb_id != other.reimb_id)
			return false;
		if (resolved != other.resolved)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statusId != other.statusId)
			return false;
		if (submitted != other.submitted)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", submitted=" + submitted
				+ ", resolved=" + resolved + ", description=" + description + ", type=" + type + ", typeId=" + typeId
				+ ", status=" + status + ", statusId=" + statusId + ", toString()=" + super.toString() + "]";
	}

}
