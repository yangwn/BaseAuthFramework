package com.base.privilege.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Resource implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private String url;

	private String remark;

	private Integer parentId;

	private String structure;

	private Integer sortNo;

	private String moduleFlag;

	private Integer type;

	private String createPerson;

	private Date createDate;

	private String updatePerson;

	private Date updateDate;

	private String permission;

	private Resource parent;

	private List<Resource> childResource;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public Integer getSortNo() {
		return sortNo;
	}

	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getModuleFlag() {
		return moduleFlag;
	}

	public void setModuleFlag(String moduleFlag) {
		this.moduleFlag = moduleFlag;
	}

	public String getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdatePerson() {
		return updatePerson;
	}

	public void setUpdatePerson(String updatePerson) {
		this.updatePerson = updatePerson;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Resource getParent() {
		return parent;
	}

	public void setParent(Resource parent) {
		this.parent = parent;
	}

	public List<Resource> getChildResource() {
		return childResource;
	}

	public void setChildResource(List<Resource> childResource) {
		this.childResource = childResource;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "Resource [id=" + id + ", name=" + name + ", url=" + url + ", remark=" + remark + ", parentId="
				+ parentId + ", structure=" + structure + ", sortNo=" + sortNo + ", moduleFlag=" + moduleFlag
				+ ", type=" + type + ", createPerson=" + createPerson + ", createDate=" + createDate
				+ ", updatePerson=" + updatePerson + ", updateDate=" + updateDate + "]";
	}

}