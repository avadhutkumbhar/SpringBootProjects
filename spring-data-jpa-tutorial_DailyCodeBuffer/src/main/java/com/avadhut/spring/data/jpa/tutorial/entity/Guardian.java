package com.avadhut.spring.data.jpa.tutorial.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_guardian")
@AttributeOverrides({
	@AttributeOverride( name="name", column=@Column(name="guardian_name") ),
	@AttributeOverride(name = "email",column = @Column(name="guardian_email")),
	@AttributeOverride(name = "mobile",column = @Column(name="guardian_mobile"))
})
public class Guardian {

	private String name;
	private String email;
	private String mobile;
	
}
